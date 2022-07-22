package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OpeningHours implements Serializable {
    @JoinColumn(name = "userId")
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    Doctor doctor;

    @NotNull
    String dayOfTheWeek;
    @NotNull
    Timestamp open;
    @NotNull
    Timestamp close;
    @NotNull
    Timestamp lunchHour;
    @NotNull
    LocalDateTime startDate;
    LocalDateTime endDate;
}
