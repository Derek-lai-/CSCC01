package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.Instructor;
import com.example.minutemadeproject.InstructorHelper;
import com.example.minutemadeproject.R;
import com.example.minutemadeproject.R.layout;
import com.example.minutemadeproject.R.menu;
import com.example.minutemadeproject.db.DatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignupActivity extends Activity {

	RadioGroup userType;
	RadioButton selected;
	EditText editTextUserName, editTextPassword, editTextConfirmPassword, editTextName, editTextPhone, editTextEmail;
	Button btnCreateAccount;
	Instructor instructor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		userType = (RadioGroup) findViewById(R.id.userType);
		editTextName = (EditText) findViewById(R.id.editTextName);
		editTextUserName = (EditText) findViewById(R.id.editTextUserName);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
		editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
		editTextEmail = (EditText) findViewById(R.id.editEmail);
		editTextPhone = (EditText) findViewById(R.id.editTextPhone);
		final InstructorHelper dbHelper = new InstructorHelper(getApplicationContext());
		btnCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
		
		btnCreateAccount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString())){
					selected = (RadioButton) findViewById(userType.getCheckedRadioButtonId());
					if(selected.getText().toString().equals("Teaching Assistant")){
						instructor = new Instructor(editTextUserName.getText().toString(),
								editTextPassword.getText().toString(), 
								editTextName.getText().toString(), editTextEmail.getText().toString(),
								editTextPhone.getText().toString(), true);
					}else {
						instructor = new Instructor(editTextUserName.getText().toString(),
								editTextPassword.getText().toString(), 
								editTextName.getText().toString(), editTextEmail.getText().toString(),
								editTextPhone.getText().toString(), true);
					}
					dbHelper.create(instructor);
				} else {
					editTextPassword.setText("");
					editTextConfirmPassword.setText("");
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signup, menu);
		return true;
	}

}
