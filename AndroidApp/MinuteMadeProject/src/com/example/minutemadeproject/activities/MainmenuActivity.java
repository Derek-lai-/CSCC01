package com.example.minutemadeproject.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.minutemadeproject.DisplayLessons;
import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Tutorial;
import com.j256.ormlite.dao.ForeignCollection;

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
    private List<Instructor> instructors;

    ArrayList<String> items = new ArrayList<String>();
    ListView lv = null;
    TextView welcome = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        final CourseHelper courseHelper = new CourseHelper(this);
        final TutorialHelper tutorialHelper = new TutorialHelper(this);
        final InstructorHelper instructorHelper = new InstructorHelper(this);

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
                        Course test = courses.get(0);
                        ArrayList<Assignment> curAssignments = new ArrayList<Assignment>(test.assignments);
                        Toast toasty = Toast.makeText(getApplicationContext(), curAssignments + "", Toast.LENGTH_LONG);
                        toasty.show();
                        break;
                    }
                    case Schedule: {
                        tutorials = tutorialHelper.getAll();
                        Toast toasty = Toast.makeText(getApplicationContext(), "Tutorial " +
                                tutorials.get(0)+ "," + tutorials.get(0).course.instructor, Toast.LENGTH_LONG);
                        toasty.show();
                        courses = courseHelper.getAll();
                        Toast toast = Toast.makeText(getApplicationContext(), "Course " +
                                courses, Toast.LENGTH_LONG);
                        toast.show();
                       break;
                    }
                    case Assignment: {
                        courses = courseHelper.getAll();
                        tutorials = tutorialHelper.getAll();
                        if (courses.size() < 1){
                            Toast toast = Toast.makeText(getApplicationContext(), "No courses yet," +
                                    " Please create a new course first", Toast.LENGTH_LONG);
                            toast.show();
                        } else if (tutorials.size() < 1){
                            Toast toasty = Toast.makeText(getApplicationContext(), "No Tutorials," +
                                    " Please add a tutorial to a course", Toast.LENGTH_LONG);
                            toasty.show();
                        } else {
                            Intent intent = new Intent(getApplicationContext(), AssignmentMenuActivity.class);
                            startActivity(intent);
                        }
                        break;
                    }
                    case addTutorial: {
                        instructors = instructorHelper.getAll();
                        courses = courseHelper.getAll();
                        Tutorial tutorial = new Tutorial(courses.get(0), instructors.get(0), 2, 1, 3, "Sec 2");
                        tutorialHelper.create(tutorial);
                        tutorials = tutorialHelper.getAll();
                        Toast toasty = Toast.makeText(getApplicationContext(), "Tutorial" +
                                " created - " + tutorials, Toast.LENGTH_LONG);
                        toasty.show();
                        Toast toast = Toast.makeText(getApplicationContext(), tutorials.get(0).course.name, Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    }
                    case addCourse: {
                        Instructor instructor = new Instructor("username", "name", "password", "email", "phone", false);
                        Course course = new Course("Course2", instructor);
                        courseHelper.create(course);
                        instructorHelper.create(instructor);
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