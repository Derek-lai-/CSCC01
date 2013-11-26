package com.example.minutemadeproject;

import java.util.ArrayList;
import java.util.List;

import com.example.minutemadeproject.helpers.GradeHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GradesActivity extends Activity {
	
	private GradeHelper gradeHelper;
	private Spinner spinner;
	private EditText nameField;
	private EditText stuGrade;
	private Button submitButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grades);
		
		gradeHelper = new GradeHelper(getApplicationContext());
		spinner = (Spinner) findViewById(R.id.names);
		nameField = (EditText) findViewById(R.id.student_name);
		stuGrade = (EditText) findViewById(R.id.student_grade);
		submitButton = (Button) findViewById(R.id.submit);
		
		List<String> stuName = new ArrayList<String>();
		
		
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
			Toast.makeText(getApplicationContext(), "Student name selected is:"+ parent.getItemAtPosition(pos).toString(), 
					Toast.LENGTH_SHORT);
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
