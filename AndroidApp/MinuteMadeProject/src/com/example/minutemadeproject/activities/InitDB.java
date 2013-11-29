package com.example.minutemadeproject.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.R.id;
import com.example.minutemadeproject.R.layout;
import com.example.minutemadeproject.R.menu;
import com.example.minutemadeproject.helpers.GroupHelper;
import com.example.minutemadeproject.helpers.StudentHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Group;
import com.example.minutemadeproject.models.Student;
import com.example.minutemadeproject.models.Tutorial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class InitDB extends Activity {
	Button btnCourse, btnGroup, btnGrade;
	private GroupHelper groupHelper;
	private StudentHelper studentHelper;
	private TutorialHelper tutHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_init_db);

		btnCourse = (Button) findViewById(R.id.courseInit);
		btnGroup = (Button) findViewById(R.id.groupInit);
		btnGrade = (Button) findViewById(R.id.gradeInit);

		btnCourse.setOnClickListener(new CourseOnClickListener());
		btnGroup.setOnClickListener(new GroupOnClickListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.init_db, menu);
		return true;
	}

	private class GroupOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			groupHelper = new GroupHelper(getApplicationContext());
			studentHelper = new StudentHelper(getApplicationContext());
			tutHelper = new TutorialHelper(getApplicationContext());
			List<Student> students = studentHelper.getAll();
			List<Tutorial> tuts = tutHelper.getAll();
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(getAssets().open("group.txt")));
				// do reading, usually loop until end of file reading
				String mLine = reader.readLine();
				while (mLine != null) {
					// process line
					String[] temp = mLine.split(",");
					List<Student> groupList = null;
					for(int i=0; i< temp.length; i++){
						for(Student s : students){
							if(s.utorid.equalsIgnoreCase(temp[i])){
								groupList.add(s);
							}
						}
					}
					groupHelper.create(new Group(tuts.get(0), groupList));
					mLine = reader.readLine();
				}
				Toast.makeText(getApplicationContext(), "Initialized Group", Toast.LENGTH_SHORT);
				reader.close();

			} catch (IOException e) {

			}
		}
	}
	
	private class CourseOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(getAssets().open("course.txt")));

				// do reading, usually loop until end of file reading
				String mLine = reader.readLine();
				while (mLine != null) {
					// process line
					String[] temp = mLine.split(",");
					// temp[0] is course name
					// temp[1] is section
					// temp[2] is day of class
					// temp[3] is starttime
					// temp[4] is end time
					// temp[5] is roomnumber

					// TODO for david kua, create the course and dump it into the db
					// DO this in the loop
					mLine = reader.readLine();
				}
				Toast.makeText(getApplicationContext(), "Initialized course", Toast.LENGTH_SHORT);
				reader.close();

			} catch (IOException e) {
				Toast.makeText(getApplicationContext(), "Couldn't read file", Toast.LENGTH_SHORT);
			}
			
		}
		
	}
}
