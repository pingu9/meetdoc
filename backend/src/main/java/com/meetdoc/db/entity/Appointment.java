package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int appointmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorUserId")
    Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientUserId")
    User user;

    @NotNull
    LocalDateTime appointmentDate;
    @NotNull
    String symptom;
    @NotNull
    BigDecimal charge;
    @NotNull
    String status;

    String roomLink;
    String enterDoctor;
    String enterPatient;
    String leaveDoctor;
    String leavePatient;

    String icd;
    LocalDateTime prescriptionDate;
    String prescriptionDescription;

    LocalDateTime settlementDate;
}
