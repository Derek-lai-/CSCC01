package com.example.minutemadeproject.activities;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NotificationService extends Service{
	@Override
	public void onCreate()  {

	   super.onCreate();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	http://stackoverflow.com/questions/19639294/android-notification-with-alarmmanager-broadcast-and-service
	public void displayNote(){
		  Intent mainIntent = new Intent(this, myActivity.class);
		     PendingIntent pIntent = PendingIntent.getActivity(this, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);      

		     NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
		     Notification.Builder builder = new Notification.Builder(this);

		     builder.setContentIntent(pIntent)
		     .setAutoCancel(true)
		     .setSmallIcon(R.drawable.ic_noti)
		     .setTicker(getString(R.string.notifmsg))        
		     .setContentTitle(getString(R.string.app_name))
		     .setContentText(getString(R.string.notifmsg));

		     nm.notify(0, builder.build());
	}
	
}
