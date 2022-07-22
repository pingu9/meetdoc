package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class MedicDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int departmentCode;
    @NotNull
    String departmentName;
}
