<template>
	<div id="main-container" class="container">
		<div id="session">
			<div id="session-header">
				<h1 id="session-title">{{ sessionId }}</h1>
				<input class="btn btn-large btn-success" type="button" id="buttonMuteAudio" @click="toggleMuteOption()" value="Mute Audio" v-if="isAudioActive">
				<input class="btn btn-large btn-warning" type="button" id="buttonUnmuteAudio" @click="toggleMuteOption()" value="Unmute Audio" v-if="!isAudioActive">
				<input class="btn btn-large btn-success" type="button" id="buttonStopVideo" @click="toggleVideoEnableOption()" value="Stop Video" v-if="isVideoActive">
				<input class="btn btn-large btn-warning" type="button" id="buttonStartVideo" @click="toggleVideoEnableOption()" value="Start Video" v-if="!isVideoActive">
				<input class="btn btn-large btn-danger" type="button" id="buttonLeaveSession" @click="leaveSession" value="Leave session">
			</div>
			<div id="main-video" class="col-md-6">
				<user-video :stream-manager="mainStreamManager"/>
			</div>
			<div id="video-container" class="col-md-6">
				<user-video :stream-manager="publisher" @click="updateMainVideoStreamManager(publisher)"/>
				<user-video v-for="sub in subscribers" :key="sub.stream.connection.connectionId" :stream-manager="sub" @click="updateMainVideoStreamManager(sub)"/>
			</div>
		</div>
	</div>
</template>

<script>
import axios from 'axios';
import { OpenVidu } from 'openvidu-browser';
import UserVideo from '../components/UserVideo';
import { mapGetters, mapMutations } from 'vuex';

axios.defaults.headers.post['Content-Type'] = 'application/json';

const OPENVIDU_SERVER_URL = "";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
	name: 'App',

	components: {
		UserVideo,
	},

	data () {
		return {
			OV: undefined,
			session: undefined,
			mainStreamManager: undefined,
			publisher: undefined,
			subscribers: [],
			isAudioActive: undefined,
			isVideoActive: undefined,

			userType: '',
			sessionId: '',
			userName: '',
		}
	},
	created(){
		if(this.$route.params.appointmentId !== '' && this.$route.params.appointmentId !==  undefined && this.$route.params.appointmentId !== null){
			this.setMeetingInfo({appointmentId: this.$route.params.appointmentId, userType:localStorage.getItem('userType'), myUserName: this.$route.params.myUserName});
		}
		this.sessionId = this.getMeetingInfo.appointmentId;
		this.userType = this.getMeetingInfo.userType;
		this.userName = this.getMeetingInfo.myUserName;
		console.log(this.sessionId + " "+ this.userType +" "+this.userName);
		this.joinSession();
	},
	computed:{
		...mapGetters(['getMeetingInfo']),
	},
	methods: {
		...mapMutations(['setMeetingInfo']),
		joinSession () {
			this.OV = new OpenVidu();
			this.session = this.OV.initSession();

			this.session.on('streamCreated', ({ stream }) => {
				const subscriber = this.session.subscribe(stream);
				this.subscribers.push(subscriber);
			});

			this.session.on('streamDestroyed', ({ stream }) => {
				const index = this.subscribers.indexOf(stream.streamManager, 0);
				if (index >= 0) {
					this.subscribers.splice(index, 1);
				}
			});

			this.session.on('exception', ({ exception }) => {
				console.warn(exception);
			});

			this.getToken(this.sessionId).then(token => {
				this.session.connect(token, { clientData: this.userName + " ("+ (this.userType == "U" ? "환자" : "의사") +")" })
					.then(() => {

						let publisher = this.OV.initPublisher(undefined, {
							audioSource: undefined,
							videoSource: undefined,
							publishAudio: true,
							publishVideo: true,
							resolution: '640x480',
							frameRate: 30,
							insertMode: 'APPEND',	// How the video is inserted in the target element 'video-container'
							mirror: true
						});

						this.mainStreamManager = publisher;
						this.publisher = publisher;
						this.isAudioActive = publisher.publishAudio;
						this.isVideoActive = publisher.publishVideo;

						this.session.publish(this.publisher);
					})
					.catch(error => {
						console.log('There was an error connecting to the session:', error.code, error.message);
					});
			});


			const currentAppointmentId = this.getMeetingInfo.appointmentId;
			if (this.userType === 'D') {
				axios
					.patch(`/api/meeting/enter/doctor/${currentAppointmentId}`);
			} else if (this.userType === 'U') {
				axios
					.patch(`api/meeting/enter/patient/${currentAppointmentId}`);
			}	
			
			window.addEventListener('beforeunload', this.leaveSession)
		},

		leaveSession () {
			if (this.session) this.session.disconnect();
			
			this.isAudioActive = undefined;
			this.isVideoActive = undefined;
			this.session = undefined;
			this.mainStreamManager = undefined;
			this.publisher = undefined;
			this.subscribers = [];
			this.OV = undefined;

			const currentAppointmentId = this.getMeetingInfo.appointmentId;
			if (this.userType === 'D') {
				axios
					.patch(`/api/meeting/leave/doctor/${currentAppointmentId}`);
			} else if (this.userType === 'U') {
				axios
					.patch(`/api/meeting/leave/patient/${currentAppointmentId}`);
			}	

			window.removeEventListener('beforeunload', this.leaveSession);
			this.$router.push('/');
		},

		updateMainVideoStreamManager (stream) {
			if (this.mainStreamManager === stream) return;
			this.mainStreamManager = stream;
		},

		toggleMuteOption () {
			this.isAudioActive = !this.isAudioActive;
			this.publisher.publishAudio(this.isAudioActive);
		},

		toggleVideoEnableOption () {
			this.isVideoActive = !this.isVideoActive;
			this.publisher.publishVideo(this.isVideoActive);
		},

		getToken (sessionId) {
			return this.createSession(sessionId).then(sessionId => this.createToken(sessionId));
		},

		createSession (sessionId) {
			return new Promise((resolve, reject) => {
				axios
					.post(`${OPENVIDU_SERVER_URL}/openvidu/api/sessions`, JSON.stringify({
						customSessionId: sessionId,
					}), {
						auth: {
							username: 'OPENVIDUAPP',
							password: OPENVIDU_SERVER_SECRET,
						},
					})
					.then(response => response.data)
					.then(data => resolve(data.id))
					.catch(error => {
						if (error.response.status === 409) {
							resolve(sessionId);
						} else {
							console.warn(`No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}`);
							if (window.confirm(`No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${OPENVIDU_SERVER_URL}"`)) {
								location.assign(`${OPENVIDU_SERVER_URL}/accept-certificate`);
							}
							reject(error.response);
						}
					});
			});
		},

		createToken (sessionId) {
			return new Promise((resolve, reject) => {
				axios
					.post(`${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${sessionId}/connection`, {}, {
						auth: {
							username: 'OPENVIDUAPP',
							password: OPENVIDU_SERVER_SECRET,
						},
					})
					.then(response => response.data)
					.then(data => resolve(data.token))
					.catch(error => reject(error.response));
			});
		},
	}
}
</script>
