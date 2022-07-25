package com.meetdoc.db.repository;

import com.meetdoc.db.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class DoctorMedicDepartmentRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QDoctor qDoctor = QDoctor.doctor;
    QDoctorMedicDepartment qDoctorMedicDepartment = QDoctorMedicDepartment.doctorMedicDepartment;

    public Collection<DoctorMedicDepartment> findDepartmentByUserId(String userId) {
        List<DoctorMedicDepartment> list = jpaQueryFactory.select(qDoctorMedicDepartment).from(qDoctorMedicDepartment)
                .where(qDoctor.userId.eq(userId)).fetch();
        return list == null ? Collections.emptyList() : list;
    }
}
