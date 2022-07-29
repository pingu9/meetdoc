package com.meetdoc.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DayOff implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @Id
    Doctor doctor;

    LocalDate dayOffDate;
}
