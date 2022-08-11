<template>
	<div id="main-container" class="container">
		<div id="session">
			<div id="session-header">
				<h1 id="session-title">{{ sessionId }}</h1>
				<input class="btn btn-large btn-success" type="button" id="buttonMuteAudio" @click="toggleMuteOption()"
					value="Mute Audio" v-if="isAudioActive">
				<input class="btn btn-large btn-warning" type="button" id="buttonUnmuteAudio"
					@click="toggleMuteOption()" value="Unmute Audio" v-if="!isAudioActive">
				<input class="btn btn-large btn-success" type="button" id="buttonStopVideo"
					@click="toggleVideoEnableOption()" value="Stop Video" v-if="isVideoActive">
				<input class="btn btn-large btn-warning" type="button" id="buttonStartVideo"
					@click="toggleVideoEnableOption()" value="Start Video" v-if="!isVideoActive">
				<input class="btn btn-large btn-danger" type="button" id="buttonLeaveSession" @click="leaveSession"
					value="Leave session">
			</div>
			<div id="session-content">
				<div id="session-video">
					<div id="main-video" class="col-md-6">
						<user-video :stream-manager="mainStreamManager" />
					</div>
					<div id="video-container" class="col-md-6">
						<user-video :stream-manager="publisher" @click="updateMainVideoStreamManager(publisher)" />
						<user-video v-for="sub in subscribers" :key="sub.stream.connection.connectionId"
							:stream-manager="sub" @click="updateMainVideoStreamManager(sub)" />
					</div>
				</div>
				<div id="session-chat">
					<div>
						<b-list-group class="border-0" v-for="(msg,idx) in messageData" v-bind:key="idx">
							<div class="d-flex w-100 justify-content-between">
								<small class="text-muted">{{msg.from}}</small>
								<small class="text-muted">{{msg.time}}</small>
							</div>
							<p class="mb-1">{{msg.message}}</p>
						</b-list-group>
						<v-divider inset></v-divider>
					</div>
					<div class="input-group mb-3">
						<input type="text" class="form-control" id="chat-input" placeholder="여기에 메시지를 입력하세요."
							@keyup.enter="sendMessage()" v-model="inputMessage" />
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" id="chat-button" type="button"
								@click="sendMessage()">전송</button>
						</div>
					</div>
				</div>

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

	data() {
		return {
			OV: undefined,
			session: undefined,
			mainStreamManager: undefined,
			publisher: undefined,
			subscribers: [],
			isAudioActive: undefined,
			isVideoActive: undefined,
			inputMessage: '',
			messageData: [],

			userType: '',
			sessionId: '',
			userName: '',
		}
	},
	created() {
		if (this.$route.params.appointmentId !== '' && this.$route.params.appointmentId !== undefined && this.$route.params.appointmentId !== null) {
			this.setMeetingInfo({ appointmentId: this.$route.params.appointmentId, userType: this.$route.params.userType, myUserName: this.$route.params.myUserName });
		}
		this.sessionId = this.getMeetingInfo.appointmentId;
		this.userType = this.getMeetingInfo.userType;
		this.userName = this.getMeetingInfo.myUserName;
		this.joinSession();
	},
	computed: {
		...mapGetters(['getMeetingInfo']),
	},
	methods: {
		...mapMutations(['setMeetingInfo']),
		joinSession() {
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
				//chat event
				this.session.on('signal', (event) => {
					let now = new Date();
					this.messageData.push({"from": event.from.data.substring(15, event.from.data.length - 2), "message" : event.data, "time" : now.toLocaleTimeString()});

					console.log(event.from.data.substring(15, event.from.data.length - 2) + " : " + event.data);
				});

				this.session.connect(token, { clientData: this.userName + " (" + (this.userType === 'U' ? "환자" : "의사") + ")" })
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

		leaveSession() {
			if (this.session) this.session.disconnect();

			this.inputMessage = '',
			this.messageData = [],
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

		updateMainVideoStreamManager(stream) {
			if (this.mainStreamManager === stream) return;
			this.mainStreamManager = stream;
		},

		toggleMuteOption() {
			this.isAudioActive = !this.isAudioActive;
			this.publisher.publishAudio(this.isAudioActive);
		},

		toggleVideoEnableOption() {
			this.isVideoActive = !this.isVideoActive;
			this.publisher.publishVideo(this.isVideoActive);
		},

		sendMessage() {
			this.session.signal({
				data: this.inputMessage,
				to: [],
				type: 'chat'
			})
			.then(() => {
				this.inputMessage = '';
			})
			.catch(error => {
				console.error(error);
			});
		},


		getToken(sessionId) {
			return this.createSession(sessionId).then(sessionId => this.createToken(sessionId));
		},

		createSession(sessionId) {
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

		createToken(sessionId) {
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

<style scoped>
.session-video {
	background: red;
	float: left;
}

.session-chat {
	background: blue;
	float: right;
}
</style>