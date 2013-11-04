package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.minutemadeproject.Assignment;
import com.example.minutemadeproject.AssignmentHelper;
import com.example.minutemadeproject.GradeHelper;
import com.example.minutemadeproject.R;



public class AssignmentViewActivity extends Activity{

    public AssignmentHelper helper;
    Assignment assignment = null;
    public GradeHelper gradeHelper;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentmenu);

        Intent i = getIntent();
        int assignmentId = i.getIntExtra("assignment", 0);
        helper = new gradeHelper(getApplicationContext());
        assignment = helper.getAssignment(assignmentId);

        TextView title = (TextView) findViewById(R.id.assignmentTitle);
        title.setText(assignment.name);

        TextView course = (TextView) findViewById(R.id.coursecode);
        course.setText(assignment.course.toString());

        TextView tutorial = (TextView) findViewById(R.id.tutorial);
        tutorial.setText(assignment.tutorial);

        TextView due = (TextView) findViewById(R.id.duedate);
        due.setText("Assigned: " + assignment.postDate + " Due: " + assignment.dueDate);

        TextView details = (TextView) findViewById(R.id.duedate);
        details.setText("Assigned: " + assignment.postDate + " Due: " + assignment.dueDate);

        Button btnEditPaper = (Button) findViewById(R.id.editAssignment);
        Button btnEditGrades = (Button) findViewById(R.id.editGrades);
        btnEditPaper.setOnClickListener(paper);
        btnEditGrades.setOnClickListener(grade);
    }

    View.OnClickListener paper = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), AssignmentEditActivity.class);
            i.putExtra("id", assignment.id);
            startActivity(i);
        }
    };
    View.OnClickListener grade = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), AssignmentStudentListActivity.class);
            i.putExtra("course", assignment.grades);
            startActivity(i);
        }
    };
}
