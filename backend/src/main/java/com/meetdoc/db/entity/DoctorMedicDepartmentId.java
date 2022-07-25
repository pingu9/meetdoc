package com.meetdoc.db.entity;

import java.io.Serializable;

public class DoctorMedicDepartmentId implements Serializable {
    String doctor;
    int medicDepartment;

    public DoctorMedicDepartmentId() {}
    public DoctorMedicDepartmentId(String doctor, int medicDepartment) {
        this.medicDepartment = medicDepartment;
        this.doctor = doctor;
    }
}
