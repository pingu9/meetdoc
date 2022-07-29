package com.meetdoc.db.repository;

import com.meetdoc.db.entity.OpeningHours;
import com.meetdoc.db.entity.QOpeningHours;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OpeningHoursRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QOpeningHours qOpeningHours = QOpeningHours.openingHours;


    public Optional<OpeningHours> findOpeningHourByIdAndWeekDay(String userId, String weekDay) {
        OpeningHours openingHour = jpaQueryFactory
                .select(qOpeningHours)
                .from(qOpeningHours)
                .where(qOpeningHours.doctor.userId.eq(userId)
                        .and(qOpeningHours.dayOfTheWeek.eq(weekDay)))
                .fetchOne();
        if (openingHour == null) return Optional.empty();
        return Optional.ofNullable(openingHour);
    }

}
