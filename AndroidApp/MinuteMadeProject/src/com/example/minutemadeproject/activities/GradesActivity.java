package com.example.minutemadeproject.activities;

import java.util.ArrayList;
import java.util.List;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.R.id;
import com.example.minutemadeproject.R.layout;
import com.example.minutemadeproject.R.menu;
import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.helpers.GradeHelper;
import com.example.minutemadeproject.helpers.StudentHelper;
import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.models.Grade;
import com.example.minutemadeproject.models.Student;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GradesActivity extends Activity {
	
	private Spinner spinner;
	private EditText nameField;
	private EditText stuGrade;
	private Button submitButton;
	private StudentHelper studentHelper;
	private AssignmentHelper assignmentHelper;
	private GradeHelper gradeHelper;
	private Assignment assignment;
	private List<Student> students;
	private Student curStudent = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grades);
		
		gradeHelper = new GradeHelper(getApplicationContext());
		spinner = (Spinner) findViewById(R.id.names);
		nameField = (EditText) findViewById(R.id.student_name);
		stuGrade = (EditText) findViewById(R.id.student_grade);
		submitButton = (Button) findViewById(R.id.submit);
		studentHelper = new StudentHelper(getApplicationContext());
		assignmentHelper = new AssignmentHelper(getApplicationContext());
		gradeHelper = new GradeHelper(getApplicationContext());
		
		//set nameField to be not editable
		nameField.setKeyListener(null);
		
		int assignmentId = 0, courseId = 0, tutorialId = 0;
		Bundle bundle = getIntent().getExtras();
		if(bundle != null){
			assignmentId = bundle.getInt("assignmentId");
			courseId = bundle.getInt("courseId");
			tutorialId = bundle.getInt("tutorialId");
		}
		
		assignment = assignmentHelper.getAssignment(assignmentId);
		
		students = studentHelper.getAll();
		List<String> stuName = new ArrayList<String>();
		for(Student s : students){
			if (s.tutorial.id == tutorialId){
				stuName.add(s.name);
			}
		}
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, stuName);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner.setAdapter(dataAdapter);
		
		spinner.setOnItemSelectedListener(new CustomItemSelectionListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grades, menu);
		return true;
	}
	
	private class CustomItemSelectionListener implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			// TODO Auto-generated method stub
			for(Student s : students){
				if(s.name.equalsIgnoreCase(parent.getItemAtPosition(pos).toString())){
					curStudent = s;
					nameField.setText(parent.getItemAtPosition(pos).toString());
				}
			}
			submitButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String grade = stuGrade.getText().toString(); 
					if(grade != null){
						Grade g = new Grade(assignment, curStudent, Double.parseDouble(grade));
						gradeHelper.create(g);
					}
					else{						
						Toast.makeText(getApplicationContext(), "Please enter a grade", Toast.LENGTH_SHORT);
					}
					
				}
			});
			Toast.makeText(getApplicationContext(), "Student name selected is:"+ parent.getItemAtPosition(pos).toString(), 
					Toast.LENGTH_SHORT);
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
