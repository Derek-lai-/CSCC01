package com.example.minutemadeproject.activities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    int assignmentId;
    int[] extra;
    Course course = null;
    Assignment assignment = null;
    private String newTitle = null;
    private String newTutorial = null;
    private Date newDue = null;
    private Date newAssign = null;
    private String newDetails = null;
    private double newMark;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentcreate);

        //pulls extra info from previous activity
        final Bundle a = getIntent().getExtras();

        //checks of you are editting a existing assignment
        if (a != null){
            extra = a.getIntArray("id");
            assignmentId = extra[1];
        }

        //create courseHelper
        CourseHelper chelper = new CourseHelper(this);
        //sets course object with courseId from pervious activity
        course = chelper.get(extra[0]);
        helper = new AssignmentHelper(this);

        //gets ID of assignment if passed from previous activity
        if (assignment != null){
        	assignment = helper.getAssignment(assignmentId);
        }

        //sets editText buttons on layout
        final EditText title = (EditText) findViewById(R.id.editName);
    	final EditText tutorial = (EditText) findViewById(R.id.editTutorial);
    	final EditText assign = (EditText) findViewById(R.id.editADate);
    	final EditText due = (EditText) findViewById(R.id.editDDate);
    	final EditText details = (EditText) findViewById(R.id.editDetails);
    	final EditText marks = (EditText) findViewById(R.id.editMark);

        //fills in pre existing data if an assignment already exist
        if (assignment != null){
            tutorial.setText(assignment.tutorial);
            assign.setText(assignment.postDate.toString());
            due.setText(assignment.dueDate.toString());
            details.setText(assignment.description);
        	title.setText(assignment.name);
        	String m = String.valueOf(assignment.totalMark);
        	marks.setText(m);
        }

        //define save button
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
        	
    		@SuppressLint("SimpleDateFormat")
			@Override
    		public void onClick(View v) {
    			Intent i = new Intent(getApplicationContext(), AssignmentViewActivity.class);

                //set SimpleDateFormatter, pases string and sets as a date object
    			SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");

                //gets the string text from the editable text and sets variables to them
    			newTitle = title.getText().toString();
    			newTutorial = tutorial.getText().toString();
    			newDetails = details.getText().toString();
    			String tempmark = marks.getText().toString();
    			String ddate = due.getText().toString();
    			String adate = assign.getText().toString();

                //attempt parsing and some of the variables
    			try {
    				newMark = (Double.parseDouble(tempmark));	
					newAssign = formatter.parse(adate);
					newDue = formatter.parse(ddate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

                //checks for existing assingment, if exist, update database
                if (a != null){
                    assignment.name = newTitle;
                    assignment.tutorial = newTutorial;
                    assignment.dueDate = newDue;
                    assignment.postDate = newAssign;
                    assignment.totalMark = newMark;
                    helper.update(assignment);
                // if previous assingment does not exist, create new assignment object and put
                    //into database
                } else {
    			    assignment = new Assignment(newTitle, newTutorial, null, null, newAssign, newDue, newMark);
    			    helper.create(assignment);
                }

                //testing, get last item and put as a Tost
                List<Assignment> list = helper.getAll();
                Assignment ass = list.get(list.size() -1);
                Toast toast = Toast.makeText(getApplicationContext(), ass.name, Toast.LENGTH_LONG);
                toast.show();
                finish();
    	    }
        }); 
    }
}
