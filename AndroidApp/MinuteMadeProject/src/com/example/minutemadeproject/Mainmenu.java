package com.example.minutemadeproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Mainmenu extends Activity {

	private enum MenuItem {
		Lesson, Course, Schedule;
	}

	ArrayList<String> items = new ArrayList<String>();
	ListView lv = null;
	TextView welcome = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		lv = (ListView) findViewById(R.id.list);
		items.add("Lesson");
		items.add("Course");
		items.add("Schedule");
		welcome = (TextView) findViewById(R.id.welcome);
		welcome.setText("Welcome " + VarHolder.getUser().username);
		ArrayAdapter<String> arrayAdpater = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(arrayAdpater);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parentAdapter, View view,
					int position, long id) {
				TextView clickedItem = (TextView) view;
				MenuItem i = MenuItem.valueOf(clickedItem.getText() + "");
				switch (i) {
				case Lesson: {
					// Launch Lesson
					break;
				}
				case Course: {
					// Launch Lesson
					break;
				}
				case Schedule: {
					// Launch Lesson
					break;
				}
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
