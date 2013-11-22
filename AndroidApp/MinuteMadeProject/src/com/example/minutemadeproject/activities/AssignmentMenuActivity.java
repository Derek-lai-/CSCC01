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

import java.util.ArrayList;
import java.util.List;
import com.example.minutemadeproject.R;

import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Tutorial;

public class AssignmentMenuActivity extends Activity {

    AssignmentHelper assignmentHelper;
    CourseHelper courseHelper;
    TutorialHelper tutorialHelper;
    private List<Course> courses;
    private Course curCourse;
    private Assignment pickAssignment;
    private Tutorial pickTutorial;
    private List<Tutorial> curTutorials;
    private List<Assignment> curAssignments;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentpicker);

        assignmentHelper = new AssignmentHelper(this);
        courseHelper = new CourseHelper(this);
        tutorialHelper = new TutorialHelper(this);

        courses = courseHelper.getAll();

        Spinner courseSpinner = (Spinner) findViewById(R.id.courseSpinner);
        Spinner assignmentSpinner = (Spinner) findViewById(R.id.assignmentSpinner);
        Spinner tutorialSpinner = (Spinner) findViewById(R.id.tutorialSpinner);

        ArrayAdapter<String> courseAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, courses);
        final ArrayAdapter<String> tutorialAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, curTutorials);
        final ArrayAdapter<String> assignmentAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, curAssignments);

        courseAdapt.setDropDownViewResource(R.layout.assignmentcreate);
        assignmentAdapt.setDropDownViewResource(R.layout.assignmentcreate);
        tutorialAdapt.setDropDownViewResource(R.layout.assignmentcreate);

        courseSpinner.setAdapter(courseAdapt);
        assignmentSpinner.setAdapter(assignmentAdapt);
        tutorialSpinner.setAdapter(tutorialAdapt);

        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                curCourse = courses.get(i);
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
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                pickTutorial = curTutorials.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });


        tutorialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                pickAssignment = curAssignments.get(i);

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
                i.putExtra("assignment", id);
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
}