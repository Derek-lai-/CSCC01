package com.example.minutemadeproject.utils;

public class Time {
    public static String stringifyTime(int hr, int min) {
        String hour = Integer.toString(hr);
        String minute = Integer.toString(min);

        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    public static Integer intifyTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0] + parts[1]);
    }

    public static String formatTime(int time) {
        String strTime = Integer.toString(time);
        String hour;
        String min;
        if (time < 1000) {
            hour = strTime.substring(0, 1);
            min = strTime.substring(1, 3);
        } else {
            hour = strTime.substring(0, 2);
            min = strTime.substring(2, 4);
        }
        return hour + ":" + min;
    }
}
