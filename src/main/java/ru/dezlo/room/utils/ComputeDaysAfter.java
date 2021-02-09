//package ru.dezlo.room.utils;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.TimeZone;
//
//@Slf4j
//public class ComputeDaysAfter {
//
//    @Data
//    public static class TimeAfter {
//
//        private Long hoursAfter;
//        private Long daysAfter;
//    }
//
//    public static TimeAfter computeDaysAfter(Date date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String pcDate = dateFormat.format(Calendar.getInstance().getTime());
//        String dbDate = dateFormat.format(date);
//
//        LocalDateTime date1 = LocalDateTime.parse(pcDate, formatter);
//        LocalDateTime date2 = LocalDateTime.parse(dbDate, formatter);
//
//        long hours = ChronoUnit.HOURS.between(date2, date1);
//        TimeAfter timeAfter = new TimeAfter();
//
//        if (hours < 24) {
//            timeAfter.setDaysAfter(0L);
//            timeAfter.setHoursAfter(hours);
//        } else {
//            timeAfter.setDaysAfter(hours / 24);
//            timeAfter.setHoursAfter(hours % 24);
//        }
//        return timeAfter;
//
//    }
//}
