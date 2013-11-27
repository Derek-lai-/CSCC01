package com.example.minutemadeproject.activities;

import java.util.ArrayList;
import android.app.Activity;

import com.example.minutemadeproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ScheduleActivity extends Activity{

	private enum MenuItem {
		Lesson, Course, Schedule;
	}

	ArrayList<String> upcoming_items = new ArrayList<String>();
	ListView lv = null;
	TextView welcome = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //Intent intent = getIntent();
		setContentView(R.layout.schedule);
		lv = (ListView) findViewById(R.id.lvUpcoming);
		upcoming_items.add("Schedule");
		welcome = (TextView) findViewById(R.id.welcome);
		//welcome.setText("Welcome " + VarHolder.getUser().username);
		welcome.setText("Welcome");

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, upcoming_items);
		lv.setAdapter(arrayAdapter);
    }

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds upcoming_items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main_menu, menu);
//		return true;
//	}
}
