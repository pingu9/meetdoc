package com.meetdoc.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class OpeningHours extends BaseEntity implements Serializable {
    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    Doctor doctor;

    @NotNull
    String dayOfTheWeek;
    @NotNull
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    Date open;
    @NotNull
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    Date close;
    @NotNull
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    Date lunchHour;
    @NotNull
    LocalDate startDate;
    LocalDate endDate;
}


