package ru.dezlo.room.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtils {

    public static Date datePlusDate(Date firstDate, Date secondDate){
        Calendar calendarFrom = Calendar.getInstance();
        Calendar calendarTo = Calendar.getInstance();

        log.debug("calendarFrom: " + calendarFrom.getTime());
        log.debug("calendarTo: " + calendarTo.getTime());

        calendarFrom.setTime(firstDate);
        calendarTo.setTime(secondDate);

        calendarFrom.add(Calendar.DAY_OF_MONTH, secondDate.getDay());
        calendarFrom.add(Calendar.HOUR_OF_DAY, secondDate.getHours());
        calendarFrom.add(Calendar.MINUTE, secondDate.getMinutes());
        calendarFrom.add(Calendar.SECOND, secondDate.getSeconds());

        log.debug("datePlusDate: " + calendarFrom.getTime());

        return calendarFrom.getTime();
    }
}
