package com.example.minutemadeproject.activities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.models.Course;

public class AssignmentEditActivity extends Activity{

    public AssignmentHelper helper;
    CourseHelper courseHelper;
    int assignmentId;
    Course course = null;
    String tut = null;
    Assignment assignment = null;
    private Bundle bundle;
    private String newTitle = null;
    private String newTutorial = null;
    private Date newDue = null;
    private Date newAssign = null;
    private String newDetails = null;
    private double newMark;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentcreate);

        CourseHelper courseHelper = new CourseHelper(this);
        helper = new AssignmentHelper(this);

        //pulls extra info from previous activity
        bundle = getIntent().getExtras();

        //checks of you are editting a existing assignment
        if (bundle.getInt("intent") == 1){
            assignmentId = bundle.getInt("assignmentId");
            assignment = helper.getAssignment(assignmentId);
        } else {
            course = courseHelper.get(bundle.getInt("courseName"));
            tut = bundle.getString("tutorialSection");
        }

        //sets editText buttons on layout
        final EditText title = (EditText) findViewById(R.id.editName);
    	final EditText tutorial = (EditText) findViewById(R.id.editTutorial);
    	final EditText assign = (EditText) findViewById(R.id.editADate);
    	final EditText due = (EditText) findViewById(R.id.editDDate);
    	final EditText details = (EditText) findViewById(R.id.editDetails);
    	final EditText marks = (EditText) findViewById(R.id.editMark);
    	final EditText code = (EditText) findViewById(R.id.editCode);

        //fills in pre existing data if an assignment already exist
        if (assignment != null){
        	code.setText(assignment.course.name);
            tutorial.setText(assignment.tutorial);
            assign.setText(assignment.postDate.toString());
            due.setText(assignment.dueDate.toString());
            details.setText(assignment.description);
        	title.setText(assignment.name);
        	String m = String.valueOf(assignment.totalMark);
        	marks.setText(m);
        } else {
        	tutorial.setText(tut);
        	code.setText(course.name);
        }
        

        //define save button
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
        	
    		@SuppressLint("SimpleDateFormat")
			@Override
    		public void onClick(View v) {

                //set SimpleDateFormatter, pases string and sets as a date object
    			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

                //gets the string text from the editable text and sets variables to them
    			newTitle = title.getText().toString();
    			newTutorial = tutorial.getText().toString();
    			newDetails = details.getText().toString();
    			String tempMark = marks.getText().toString();
    			String dDate = due.getText().toString();
    			String aDate = assign.getText().toString();

                //attempt parsing and some of the variables
    			try {
    				newMark = (Double.parseDouble(tempMark));
					newAssign = formatter.parse(aDate);
					newDue = formatter.parse(dDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

                //checks for existing assingment, if exist, update database
                if (bundle.getInt("intent") == 1){
                    assignment.name = newTitle;
                    assignment.tutorial = newTutorial;
                    assignment.dueDate = newDue;
                    assignment.postDate = newAssign;
                    assignment.totalMark = newMark;
                    assignment.description = newDetails;
                    helper.update(assignment);
                // if previous assingment does not exist, create new assignment object and put
                    //into database
                } else {
    			    assignment = new Assignment(newTitle, newTutorial, newDetails, course, newAssign, newDue, newMark);
    			    helper.create(assignment);
                }
                Toast toast = Toast.makeText(getApplicationContext(), assignment.name + " saved", Toast.LENGTH_LONG);
                toast.show();
                finish();

    	    }
        }); 
    }
}
