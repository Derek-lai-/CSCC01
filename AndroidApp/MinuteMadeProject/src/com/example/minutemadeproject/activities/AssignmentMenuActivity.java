package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.example.minutemadeproject.R;

import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Tutorial;

public class AssignmentMenuActivity extends Activity {

    AssignmentHelper assignmentHelper;
    CourseHelper courseHelper;
    TutorialHelper tutorialHelper;
    List<Course> courses;
    Course curCourse;
    Assignment pickAssignment;
    Tutorial pickTutorial;
    List<Tutorial> curTutorials;
    List<Assignment> curAssignments;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentpicker);

        assignmentHelper = new AssignmentHelper(this);
        courseHelper = new CourseHelper(this);
        tutorialHelper = new TutorialHelper(this);

        courses = courseHelper.getAll();
        curTutorials = new ArrayList<Tutorial>();
        curAssignments = new ArrayList<Assignment>();

        final Spinner courseSpinner = (Spinner) findViewById(R.id.courseSpinner);
        final Spinner assignmentSpinner = (Spinner) findViewById(R.id.assignmentSpinner);
        final Spinner tutorialSpinner = (Spinner) findViewById(R.id.tutorialSpinner);

        ArrayList<String> courseName = turnString(courses);
        ArrayList<String> tutorialName = turnString1(curTutorials);
        ArrayList<String> assignmentName = turnString2(curAssignments);

        ArrayAdapter<String> courseAdapt = new ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, courseName);
        ArrayAdapter<String> tutorialAdapt = new ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, tutorialName);
        ArrayAdapter<String> assignmentAdapt = new ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item, assignmentName);

        courseAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assignmentAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tutorialAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        courseSpinner.setAdapter(courseAdapt);
        assignmentSpinner.setAdapter(null);
        tutorialSpinner.setAdapter(null);

        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                curCourse = courses.get(i);

                ArrayAdapter<String> tutorialAdapt = new ArrayAdapter(getApplicationContext(), R.layout.assignmentcreate, curTutorials);
                ArrayAdapter<String> assignmentAdapt = new ArrayAdapter(getApplicationContext(), R.layout.assignmentcreate, curAssignments);

                curTutorials = new ArrayList(curCourse.tutorials);
                curAssignments = new ArrayList(curCourse.assignments);

                tutorialAdapt.notifyDataSetChanged();
                assignmentAdapt.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

        assignmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView adapter, View v, int j, long lng) {
                pickTutorial = curTutorials.get(j);
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

        tutorialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView adapter, View v, int k, long lng) {
                pickAssignment = curAssignments.get(k);

                TextView assign = (TextView) findViewById(R.id.assigned);
                TextView due = (TextView) findViewById(R.id.due);
                TextView mark =  (TextView) findViewById(R.id.marks);
                TextView details = (TextView) findViewById(R.id.details);

                assign.setText((CharSequence) pickAssignment.postDate);
                due.setText((CharSequence) pickAssignment.dueDate);
                mark.setText((int) pickAssignment.totalMark);
                details.setText(pickAssignment.description);
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

        Button editGradeButton = (Button) findViewById(R.id.grades);
        Button editAssignmentButton = (Button) findViewById(R.id.editAssignment);
        Button createAssignmentButton = (Button) findViewById(R.id.createassignment);

        editGradeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GradeEdit.class);
                int id = assignmentHelper.getId(pickAssignment);
                i.putExtra("assignmentId", id);
                i.putExtra("courseId", curCourse.id);
                i.putExtra("tutorialId", pickTutorial.id);
                startActivity(i);
            }
        });


        editAssignmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AssignmentEditActivity.class);
                int id = assignmentHelper.getId(pickAssignment);
                i.putExtra("intent", 1);
                i.putExtra("assignmentId", id);
                startActivity(i);
            }
        });


        createAssignmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AssignmentEditActivity.class);
                int courseName = curCourse.id;
                String tutorialSection = pickTutorial.section;
                i.putExtra("intent", 0);
                i.putExtra("courseName", courseName);
                i.putExtra("tutorialSection", tutorialSection);
                startActivity(i);
            }
        });

    }

    public ArrayList<String> turnString(List<Course> list){
        ArrayList<String> arrayName = new ArrayList<String>();
        for (Course c: list) {
            arrayName.add(c.name);
        }
        return arrayName;
    }
    public ArrayList<String> turnString1(List<Tutorial> list){
        ArrayList<String> arrayName = new ArrayList<String>();
        for (Tutorial t: list) {
            arrayName.add(t.section);
        }
        return arrayName;
    }
    public ArrayList<String> turnString2(List<Assignment> list){
        ArrayList<String> arrayName = new ArrayList<String>();
        for (Assignment a: list) {
            arrayName.add(a.name);
        }
        return arrayName;
    }
}
