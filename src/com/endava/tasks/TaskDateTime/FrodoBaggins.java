package com.endava.tasks.TaskDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class FrodoBaggins {
    public static void main(String[] args) {

        ZonedDateTime sydneyTime = ZonedDateTime.of(2019, 01, 01, 23, 15, 00, 0000, ZoneId.of("Australia/Sydney"));
        System.out.println(sydneyTime);
        ZonedDateTime losAngelesTime = ZonedDateTime.of(2019, 01, 01, 18, 00, 00, 0000, ZoneId.of("America/Los_Angeles"));
        System.out.println(losAngelesTime);

        long minutes = ChronoUnit.MINUTES.between(sydneyTime, losAngelesTime);


        System.out.println("The duration of flight is: " + minutes / 60 + ":" + minutes % 60);
    }
}
