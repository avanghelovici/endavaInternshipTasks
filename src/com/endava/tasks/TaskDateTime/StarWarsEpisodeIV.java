package com.endava.tasks.TaskDateTime;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class StarWarsEpisodeIV {

    private static final LocalDate SW_START_DATE = LocalDate.of(1977, Month.MAY, 25);
    public static final int MINUTES_IN_HOUR = 60;
    public static final int HOURS_IN_DAY = 24;
    public static final int PLAYTIME_HOURS = 2;

    public static void main(String[] args) {

        System.out.println("The day of the week of the release: " + SW_START_DATE.getDayOfWeek());

        Calendar start = Calendar.getInstance();
        start.set(1977, 4, 25);
        Calendar end = Calendar.getInstance();
        end.set(1979, 4, 25);

        System.out.print("Number Saturdays and Sundays between " +
                start.getTime() + " and " + end.getTime() + " are: ");
        int count = countNumberOfSundaysAndSaturdays(start, end);
        int totalPlayTimeInMinutes = count * MINUTES_IN_HOUR * PLAYTIME_HOURS;

        System.out.println("Total times played for 2 years: " + count);

        System.out.println("Minutes of playtime: " + totalPlayTimeInMinutes);

        System.out.println("Hours of playtime: " + totalPlayTimeInMinutes / MINUTES_IN_HOUR);

        System.out.println("Days of playtime: " + totalPlayTimeInMinutes / MINUTES_IN_HOUR / HOURS_IN_DAY);

    }

    private static int countNumberOfSundaysAndSaturdays(Calendar start, Calendar end) {
        int count = 0;

        while (start.before(end)) {
            if ((start.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                    || start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                count++;
                start.add(Calendar.DATE, 1);
            } else {
                start.add(Calendar.DATE, 1);
            }
        }
        return count;
    }

}



