package com.example.minutemadeproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Mainmenu extends Activity {

	ArrayList<String> items = new ArrayList<String>();
	ListView lv= null;
	TextView welcome = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		lv = (ListView) findViewById(R.id.list);
		items.add("Lessons");
		items.add("Course");
		items.add("Schedule");
		welcome = (TextView) findViewById(R.id.welcome);
		welcome.setText("Welcome " + VarHolder.getUser().username);
		ArrayAdapter<String> arrayAdpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
		lv.setAdapter(arrayAdpater);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainmenu, menu);
		return true;
	}

}
