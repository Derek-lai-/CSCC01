package com.example.minutemadeproject.activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import android.app.Activity;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Course;

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

    public CourseHelper ch;
	ArrayList<String> upcoming_items = new ArrayList<String>();
	ListView lv = null;
	TextView welcome = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //Intent intent = getIntent();
		setContentView(R.layout.schedule);
		lv = (ListView) findViewById(R.id.lvUpcoming);
        ch = new CourseHelper(this);
	    List courseList	= ch.getAll();
        for (Object li : courseList) {
            upcoming_items.add(li.toString());
        }
        upcoming_items.add("END -- Schedule");
		welcome = (TextView) findViewById(R.id.tvUpcoming);


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
