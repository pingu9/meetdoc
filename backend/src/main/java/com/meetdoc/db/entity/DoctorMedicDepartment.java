package com.meetdoc.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@IdClass(DoctorMedicDepartmentId.class)
public class DoctorMedicDepartment {

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name = "userId")
    Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name = "departmentCode")
    MedicDepartment medicDepartment;
}
