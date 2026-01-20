package com.guvi.dates;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateDemo {
    public static void main(String[] args) {

        // Instant = machine timestamp in UTC (good for logs, audit, event time).
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println("Epoch millis: " + now.toEpochMilli());

        // LocalTime = time without date/timezone (good for "opens at 6:19").
        LocalTime t1 = LocalTime.of(6, 19);
        System.out.println(t1);
        System.out.println(LocalTime.NOON);
        System.out.println(LocalTime.now());

        // LocalDate = date without time/timezone (good for birthdays, holidays).
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // LocalDateTime = date+time without timezone (human-readable, but no region context).
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2026, 1, 20, 18, 24);
        System.out.println(ldt);
        System.out.println(ldt2);

        // ZonedDateTime = date+time WITH timezone (important for schedules across regions).
        ZonedDateTime istNow = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(istNow);
    }
}