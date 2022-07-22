package com.meetdoc.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class DoctorMedicDepartment extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int doctorMedicDepartmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentCode")
    MedicDepartment medicDepartment;
}
