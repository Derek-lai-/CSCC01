package com.example.minutemadeproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class DisplayLessons extends Activity {
	
	ListView lv = null;
	ArrayList<String> items = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_lessons);
		// Show the Up button in the action bar.
		setupActionBar();
		lv = (ListView) findViewById(R.id.topic);
		items.add("course 1_tutorial 1_lesson1");
		items.add("course 1_tutorial 1_lesson2");
		items.add("course 1_tutorial 2_lesson1");
		items.add("course 2_tutorial 1_lesson1");
		ArrayAdapter<String> arrayAdpater = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, items);
		lv.setAdapter(arrayAdpater);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent(getApplicationContext(), Instructions.class);
                 startActivity(intent);
			}
		});
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_lessons, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
