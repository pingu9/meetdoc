package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
public class Doctor implements Serializable {
    @Id
    String userId;

    @JoinColumn(name = "userId")
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = ALL)
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

    String photoUrl;

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<DoctorMedicDepartment> doctorMedicDepartments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<OpeningHours> openingHours = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<DayOff> dayOffs = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = ALL, orphanRemoval = true)
    Collection<Appointment> appointments = new ArrayList<>();
}
