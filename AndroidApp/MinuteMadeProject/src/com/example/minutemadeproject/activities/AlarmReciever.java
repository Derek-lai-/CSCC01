package com.example.minutemadeproject.activities;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.minutemadeproject.R;

public class AlarmReciever extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent i = new Intent();
		PendingIntent pendIntent = PendingIntent.getActivity(context, 0, i, 0);
		NotificationManager mNM;
        mNM = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);


        NotificationCompat.Builder noteBuild = new NotificationCompat.Builder(context);
        
        noteBuild.setSmallIcon(R.drawable.icon_david);
        noteBuild.setContentTitle("You have a Tutorial!!!");
        noteBuild.setContentText("Get ready to go to Tutorial");
        noteBuild.setWhen(0);
        
       
        noteBuild.setContentIntent(pendIntent);
        Notification notification = noteBuild.build();
        
        mNM.notify(0, notification);
	}

}
