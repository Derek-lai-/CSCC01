package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.helpers.GradeHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.R;

public class AssignmentViewActivity extends Activity{

    public AssignmentHelper helper;
    Assignment assignment = null;
    public GradeHelper gradeHelper;
    int[] ids;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentmenu);

        //pulls info from previous activity
        Bundle i = getIntent().getExtras();
        ids = i.getIntArray("assignment");

        gradeHelper = new GradeHelper(this);
        helper = new AssignmentHelper(this);
        assignment = helper.getAssignment(ids[1]);

        //sets text field title as name in assignment object
        TextView title = (TextView) findViewById(R.id.assignmentTitle);
        title.setText(assignment.name);
        //sets text field course as course id in assignment object
        TextView course = (TextView) findViewById(R.id.coursecode);
        course.setText(assignment.course.toString());
        //sets text field tutorial as tutorial id in assignment object
        TextView tutorial = (TextView) findViewById(R.id.tutorial);
        tutorial.setText(assignment.tutorial);
        //sets due date
        TextView due = (TextView) findViewById(R.id.duedate);
        due.setText("Assigned: " + assignment.postDate + " Due: " + assignment.dueDate);

        TextView details = (TextView) findViewById(R.id.details);
        details.setText(assignment.description);

        //assigns buttons with onclickfunctions
        Button btnEditPaper = (Button) findViewById(R.id.editAssignment);
        Button btnEditGrades = (Button) findViewById(R.id.editGrades);
        btnEditPaper.setOnClickListener(paper);
        btnEditGrades.setOnClickListener(grade);
    }

    //opens edit assignment activity after sending ids
    View.OnClickListener paper = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), AssignmentEditActivity.class);
            i.putExtra("id", ids);
            startActivity(i);
        }
    };

    //opens list student activity after sending ids
    View.OnClickListener grade = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), AssignmentStudentListActivity.class);
            i.putExtra("id", ids);
            startActivity(i);
        }
    };
}
