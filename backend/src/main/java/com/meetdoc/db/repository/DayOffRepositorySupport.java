package com.meetdoc.db.repository;

import com.meetdoc.db.entity.DayOff;
import com.meetdoc.db.entity.QDayOff;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class DayOffRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QDayOff qDayOff = QDayOff.dayOff;

    public Optional<DayOff> findDayOffByIdAndDate(String userId, LocalDate date) {
        DayOff dayOff = jpaQueryFactory
                .select(qDayOff)
                .from(qDayOff)
                .where(qDayOff.doctor.userId.eq(userId)
                        .and(qDayOff.dayOffDate.eq(date))
                )
                .fetchOne();

        if (dayOff == null) return Optional.empty();
        return Optional.ofNullable(dayOff);
    }
}
