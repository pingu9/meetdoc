package com.meetdoc.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DayOff {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @Id
    Doctor doctor;

    LocalDateTime dayOffDate;
}
