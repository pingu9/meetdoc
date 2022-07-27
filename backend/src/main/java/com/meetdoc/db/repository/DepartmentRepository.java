package com.meetdoc.db.repository;

import com.meetdoc.db.entity.MedicDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<MedicDepartment, Integer> {

}
