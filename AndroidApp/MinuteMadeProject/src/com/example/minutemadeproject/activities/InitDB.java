package com.example.minutemadeproject.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.R.id;
import com.example.minutemadeproject.R.layout;
import com.example.minutemadeproject.R.menu;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.GroupHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.helpers.StudentHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Group;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Student;
import com.example.minutemadeproject.models.Tutorial;
import com.example.minutemadeproject.utils.Days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
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

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String currentUser = prefs.getString("CURRENT_USER", null);
                Instructor instructor = new InstructorHelper(getApplicationContext()).getByUser(currentUser);

                CourseHelper courseHelper = new CourseHelper(getApplicationContext());
                Course newCourse;

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

                    int day;
                    switch (Days.valueOf(temp[2].toUpperCase())) {
                        case SUN:
                            day = 1;
                            break;
                        case MON:
                            day = 2;
                            break;
                        case TUE:
                            day = 3;
                            break;
                        case WED:
                            day = 4;
                            break;
                        case THU:
                            day = 5;
                            break;
                        case FRI:
                            day = 6;
                            break;
                        case SAT:
                            day = 7;
                            break;
                        default:
                            day = 0;
                            break;
                    }

                    newCourse = new Course(instructor, temp[0], temp[1], day, , , temp[5]);
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
