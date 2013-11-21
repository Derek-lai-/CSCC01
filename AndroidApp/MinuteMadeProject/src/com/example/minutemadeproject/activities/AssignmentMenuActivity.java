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
    private List<Assignment> assignments;
    private Course curCourse;
    private Assignment pickAssignment;
    private Tutorial pickTutorial;
    private List<Tutorial> curTutorials;
    private List<Assignment> curAssignments;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentlist);
        assignmentHelper = new AssignmentHelper(this);
        courses = courseHelper.getAll();
        assignments = assignmentHelper.getAll();

        Spinner courseSpinner = (Spinner) findViewById(R.id.courseSpinner);
        Spinner assignmentSpinner = (Spinner) findViewById(R.id.assignmentSpinner);
        Spinner tutorialSpinner = (Spinner) findViewById(R.id.tutorialSpinner);

        ArrayAdapter<String> courseAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, courses);
        courseAdapt.setDropDownViewResource(R.layout.assignmentcreate);
        courseSpinner.setAdapter(courseAdapt);

        courseSpinner.setOnItemSelectedListener(onItemCourseSelected());
        assignmentSpinner.setOnItemSelectedListener(onAssignmentSelected());
        tutorialSpinner.setOnItemSelectedListener(onTutorialSelected());

        Button editGradeButton = (Button) findViewById(R.id.grades);
        Button editAssignmentButton = (Button) findViewById(R.id.editAssignment);
        Button createAssignmentButton = (Button) findViewById(R.id.createassignment);

        editGradeButton.setOnClickListener(editGradeButton);
        editAssignmentButton.setOnClickListener(editAssignmentButton);
        createAssignmentButton.setOnClickListener(createAssignment);

    }

    public void onItemCourseSelected(AdapterView<?> parent, View view, int post, long id){
        courseHelper = new CourseHelper(this);
        tutorialHelper = new TutorialHelper(this);

        curCourse = courses.get(post);
        curTutorials = new ArrayList(curCourse.tutorials);
        curAssignments = new ArrayList(curCourse.assignments);

        Spinner assignmentSpinner = (Spinner) findViewById(R.id.assignmentSpinner);
        Spinner tutorialSpinner = (Spinner) findViewById(R.id.tutorialSpinner);

        ArrayAdapter<String> assignmentAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, curAssignments);
        ArrayAdapter<String> tutorialAdapt = new ArrayAdapter(this, R.layout.assignmentcreate, curTutorials);

        assignmentAdapt.setDropDownViewResource(R.layout.assignmentcreate);
        tutorialAdapt.setDropDownViewResource(R.layout.assignmentcreate);

        assignmentSpinner.setAdapter(assignmentAdapt);
        tutorialSpinner.setAdapter(tutorialAdapt);

        //adapter.notifyDataSetChanged()
    }

    public void onAssignmentSelected(AdapterView<?> parent, View view, int post, long id){
        pickAssignment = curAssignments.get(post);

        TextView assign = (TextView) findViewById(R.id.assigned);
        TextView due = (TextView) findViewById(R.id.due);
        TextView mark =  (TextView) findViewById(R.id.marks);
        TextView details = (TextView) findViewById(R.id.details);

        assign.setText((CharSequence) pickAssignment.postDate);
        due.setText((CharSequence) pickAssignment.dueDate);
        mark.setText((int) pickAssignment.totalMark);
        details.setText(pickAssignment.description);
    }

    public void onTutorialSelected(AdapterView<?> parent, View view, int post, long id){
        pickTutorial = curTutorials.get(post);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editGradeButton:
                Intent i = new Intent(getApplicationContext(), GradeEdit.class);
                int id = AssignmentHelper.getId(pickAssignment);
                i.putExtra("assignment", id);
                startActivity(i);
                break;

            case R.id.editAssignmentButton:
                Intent i = new Intent(getApplicationContext(), AssignmentEditActivity.class);
                int id = AssignmentHelper.getId(pickAssignment);
                i.putExtra("intent", 1);
                i.putExtra("assignmentId", id);
                startActivity(i);
                break;

            case R.id.createAssignmentButton:
                Intent i = new Intent(getApplicationContext(), AssignmentEditActivity.class);
                int courseName = curCourse.id;
                String tutorialSection = pickTutorial.section;
                i.putExtra("intent", 0);
                i.putExtra("courseName", courseName);
                i.putExtra("tutorialSection", tutorialSection);
                startActivity(i);
                break;
        }
    }
}