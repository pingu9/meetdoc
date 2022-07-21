package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
public class Doctor {
    @JoinColumn(name = "userId")
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    User user;

    @NotNull
    String licenseNumber;
    @NotNull
    String hospitalName;
    @NotNull
    String hospitalPhone;
    @NotNull
    String hospitalZipcode;
    @NotNull
    String hospitalAddress;
    String hospitalDescription;
    @NotNull
    BigDecimal charge;

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<DoctorMedicDepartment> doctorMedicDepartments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<OpeningHours> openingHours = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<DayOff> dayOffs = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<Appointment> appointments = new ArrayList<>();
}
