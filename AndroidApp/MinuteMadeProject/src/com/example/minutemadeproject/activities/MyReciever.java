package com.example.minutemadeproject.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReciever extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent i = new Intent(context, NotificationService.class);
	    context.startService(i);
		
	}

}
