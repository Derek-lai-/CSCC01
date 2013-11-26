package com.example.minutemadeproject.activities;

import java.util.ArrayList;
import java.util.List;

import com.example.minutemadeproject.DisplayLessons;
import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Tutorial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainmenuActivity extends Activity {

    private enum MenuItem {
        Lesson, Course, Schedule, Assignment, addTutorial, addCourse;
    }
    private List<Course> courses;
    private List<Tutorial> tutorials;

    ArrayList<String> items = new ArrayList<String>();
    ListView lv = null;
    TextView welcome = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        final CourseHelper courseHelper = new CourseHelper(this);
        final TutorialHelper tutorialHelper = new TutorialHelper(this);
        lv = (ListView) findViewById(R.id.list);
        items.add("Lesson");
        items.add("Course");
        items.add("Schedule");
        items.add("Assignment");
        items.add("addTutorial");
        items.add("addCourse");
        welcome = (TextView) findViewById(R.id.welcome);
        //welcome.setText("Welcome " + VarHolder.getUser().username);
        welcome.setText("Welcome");

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
                        Intent intent = new Intent(getApplicationContext(), DisplayLessons.class);
                        startActivity(intent);
                        break;
                    }
                    case Course: {

                        break;
                    }
                    case Schedule: {
                        tutorials = tutorialHelper.getAll();
                        Toast toasty = Toast.makeText(getApplicationContext(), "Tutorial " +
                                tutorials, Toast.LENGTH_LONG);
                        toasty.show();
                        courses = courseHelper.getAll();
                        Toast toast = Toast.makeText(getApplicationContext(), "Course " +
                                courses, Toast.LENGTH_LONG);
                        toast.show();
                       break;
                    }
                    case Assignment: {
                        courses = courseHelper.getAll();
                        if (courses.size() < 1){
                            Toast toast = Toast.makeText(getApplicationContext(), "No courses yet," +
                                    " please make a new course", Toast.LENGTH_LONG);
                            toast.show();
                        } else {
                            Intent intent = new Intent(getApplicationContext(), AssignmentMenuActivity.class);
                            startActivity(intent);
                        }
                        break;
                    }
                    case addTutorial: {
                        Instructor instructor2 = new Instructor("username1", "name1", "password", "email", "phone", true);
                        Course course2 = new Course("Course 2", instructor2);
                        Tutorial tutorial = new Tutorial(course2, instructor2, 2, 10, 12, "Sec 1");
                        tutorialHelper.create(tutorial);
                        tutorials = tutorialHelper.getAll();
                        Toast toasty = Toast.makeText(getApplicationContext(), "Tutorial" +
                                " created - " + tutorials, Toast.LENGTH_LONG);
                        toasty.show();
                        break;
                    }
                    case addCourse: {
                        Instructor instructor = new Instructor("username", "name", "password", "email", "phone", false);
                        Course course = new Course("Course 1", instructor);
                        courseHelper.delete(course);
                        courses = courseHelper.getAll();
                        Toast toasty = Toast.makeText(getApplicationContext(), "Course" +
                                " created - " + courses, Toast.LENGTH_LONG);
                        toasty.show();
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
