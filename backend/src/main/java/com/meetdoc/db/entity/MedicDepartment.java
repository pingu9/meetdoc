package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
public class MedicDepartment {
    @Id
    @GeneratedValue
    int departmentCode;
    @NotNull
    String departmentName;
}
