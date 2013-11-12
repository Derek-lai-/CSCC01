package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import com.example.minutemadeproject.R;

import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Tutorial;

public class AssignmentMenu {

    AssignmentHelper assignmentHelper;
    CourseHelper courseHelper;
    TutorialHelper tutorialHelper;
    private ArrayList<Course> courses;
    private ArrayList<Assignment> assignments;
    private Course curCourse;
    private ArrayList<Tutorial> curTutorials;
    private ArrayList<Assignment> curAssignments;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentlist);
        assignmentHelper = new AssignmentHelper(this);
        courses = courseHelper.getAll();
        assignemts = assignmentHelper.getAll();

        courseSpinner = (Spinner) findViewById(R.id.courseSpinner);

        ArrayAdapter<String> courseAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, courses);
        courseAdapt.setDropDownViewResource(R.layout.assignmentcreate);
        courseSpinner.setAdapter(courseAdapt);

        courseSpinner.setOnItemSelectedListener(new onItemCourseSelected());
    }

    public void onItemCourseSelected(AdapterView<?> parent, View view, int post, long id){
        courseHelper = new CourseHelper(this);
        tutorialHelper = new TutorialHelper(this);

        curCourse = courses.get(i);
        curTutorials = tutorialHelper.findMatch(Course, curCourse);
        curAssignments = assignmentHelper.findMatch(Course, curCourse);

        assignmentSpinner = (Spinner) findViewById(R.id.assignmentSpinner);
        tutorialSpinner = (Spinner) findViewById(R.id.tutorialSpinner);

        ArrayAdapter<String> assignmentAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, curAssignments);
        ArrayAdapter<String> tutorialAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, curTutorial);

        assignmentAdapt.setDropDownViewResource(R.layout.assignmentcreate);
        tutorialAdapt.setDropDownViewResource(R.layout.assignmentcreate);

        assignmentSpinner.setAdapter(courseAdapt);
        tutorialSpinner.setAdapter(tutorialAdapt);
    }

}