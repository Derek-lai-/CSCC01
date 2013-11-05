package com.example.minutemadeproject.activities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.models.Course;

public class AssignmentEditActivity extends Activity{

    public AssignmentHelper helper;
    int assignmentId;
    int[] extra;
    Course course = null;
    Assignment assignment = null;
    private String newTitle = null;
    private String newTutorial = null;
    private Date newDue = null;
    private Date newAssign = null;
    private String newDetails = null;
    private double newMark = (Double) null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentcreate);

        Bundle a = getIntent().getExtras();
        if (a != null){
            extra = a.getIntArray("assignment");
            assignmentId = extra[1];
        }
        CourseHelper chelper = new CourseHelper(this);
        course = chelper.get(extra[0]);
        
        if (assignment != null){
        	helper = new AssignmentHelper(this);
        	assignment = helper.getAssignment(assignmentId);
        }
        
        final EditText title = (EditText) findViewById(R.id.editName);
    	final EditText tutorial = (EditText) findViewById(R.id.editTutorial);
    	final EditText assign = (EditText) findViewById(R.id.editADate);
    	final EditText due = (EditText) findViewById(R.id.editDDate);
    	final EditText details = (EditText) findViewById(R.id.editDetails);
    	final EditText marks = (EditText) findViewById(R.id.editMark);
        
        if (assignment != null){

            tutorial.setText(assignment.tutorial);
            assign.setText(assignment.postDate.toString());
            due.setText(assignment.dueDate.toString());
            details.setText(assignment.description);
        	title.setText(assignment.name);
        	String m = String.valueOf(assignment.totalMark);
        	marks.setText(m);
        }
        
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
        	
    		@SuppressLint("SimpleDateFormat")
			@Override
    		public void onClick(View v) {
    			Intent i = new Intent(getApplicationContext(), AssignmentViewActivity.class);
    			
    			SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
    			
    			newTitle = title.getText().toString();
    			newTutorial = tutorial.getText().toString();
    			newDetails = details.getText().toString();
    			String tempmark = marks.getText().toString();
    			String ddate = due.getText().toString();
    			String adate = assign.getText().toString();
    			
    			try {
    				newMark = (Double.parseDouble(tempmark));	
					newAssign = formatter.parse(adate);
					newDue = formatter.parse(ddate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    					
    			assignment = new Assignment(newTitle, newTutorial, newDetails, course,newAssign, newDue, newMark);
    			helper.create(assignment);
    			startActivity(i);
    	    }
        }); 
    }
}
