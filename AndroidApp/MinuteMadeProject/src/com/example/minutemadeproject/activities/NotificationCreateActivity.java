package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextClock;

public class NotificationCreateActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.create_notification);
	     
	     EditText editName = (EditText) findViewById(R.id.editName);
	     TextClock clock = (TextClock) findViewById(R.id.textClock);
	     CheckBox cbMon = (CheckBox) findViewById(R.id.selectMon);
	     CheckBox cbTues = (CheckBox) findViewById(R.id.selectTues);
	     CheckBox cbWed = (CheckBox) findViewById(R.id.selectWed);
	     CheckBox cbThus = (CheckBox) findViewById(R.id.selectThurs);
	     CheckBox cbFri = (CheckBox) findViewById(R.id.selectFri);
	     CheckBox cbSat = (CheckBox) findViewById(R.id.selectSat);
	     CheckBox cbSun = (CheckBox) findViewById(R.id.selectSun);
	     Button saveNote = (Button) findViewById(R.id.saveButton);
	     
	}
	
}
