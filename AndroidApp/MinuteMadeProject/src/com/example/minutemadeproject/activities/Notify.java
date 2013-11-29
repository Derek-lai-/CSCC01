package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.minutemadeproject.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Derek on 11/29/13.
 */
public class Notify {
    private Context context;
    private PendingIntent pIntent;
    private Integer hour, minute, day;
    
    
    public Notify(Context context, Integer hour, Integer minute, Integer day){
    	this.hour = hour;
    	this.minute = minute;
    	this.day = day;
    	this.context = context;
    }

    public void startAlarm(){
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.SECOND, 5);
    	pIntent = PendingIntent.getService(context, 0, new Intent(context, AlarmReciever.class), PendingIntent.FLAG_UPDATE_CURRENT);
        long firstTime = c.getTimeInMillis();
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pIntent);
    }
   
}


