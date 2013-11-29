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

/**
 * Created by Derek on 11/29/13.
 */
public class Notify extends IntentService{
    String name;
    ArrayList<String> dates;
    Integer hour, minute;
    String time;

    public Notify(){
        super("Notify");
    }

    protected void onHandleIntent(Intent intent) {
        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setSmallIcon(R.drawable.icon_david);
        nBuilder.setContentTitle(name);
        nBuilder.setContentText("MinuteMadeProject " + time + " " + dates);
        Intent rIntent = new Intent(this, MainmenuActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, rIntent, 0);
        nBuilder.setContentIntent(pIntent);
        nManager.notify(0, nBuilder.build());
    }
}


