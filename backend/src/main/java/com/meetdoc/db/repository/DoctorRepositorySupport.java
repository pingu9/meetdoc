package com.meetdoc.db.repository;

import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.QDoctor;
import com.meetdoc.db.entity.QDoctorMedicDepartment;
import com.meetdoc.db.entity.QMedicDepartment;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Repository
public class DoctorRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QDoctor qDoctor = QDoctor.doctor;

    QDoctorMedicDepartment qDoctorMedicDepartment = QDoctorMedicDepartment.doctorMedicDepartment;

    QMedicDepartment qMedicDepartment = QMedicDepartment.medicDepartment;

    Page<Doctor> page;

    public List<Doctor> findDoctorsByDepartmentIdAndPageInfo(int departmentId, String name, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qMedicDepartment.departmentCode.eq(departmentId));
        if (StringUtils.hasLength(name)) {
            builder.and(qDoctor.user.name.eq(name));
        }

        List<Doctor> list = jpaQueryFactory
                .select(qDoctor)
                .from(qDoctor)
                .join(qDoctorMedicDepartment)
                .on(qDoctor.userId.eq(qDoctorMedicDepartment.doctor.userId))
                .join(qMedicDepartment)
                .on(qDoctorMedicDepartment.medicDepartment.departmentCode.eq(qMedicDepartment.departmentCode))
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qDoctor.user.name.asc()) /* TODO n + 1 문제가 발생하는지 관측해야함  */
                .fetch();
        return list == null ? Collections.emptyList() : list;
    }
}
