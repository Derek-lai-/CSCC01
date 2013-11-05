package com.example.minutemadeproject.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Instructor;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

public class SetUpActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    public EditText editTextName;
    public EditText editTextUser;
    public EditText editTextPassword;
    public EditText editTextEmail;
    public EditText editTextPhone;
    public Button setUpButton;
    public RadioGroup radioGroupInstructor;
    public RadioButton radioButtonTA;
    public RadioButton radioButtonProf;

    private InstructorHelper instructorHelper;

    public boolean isTa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup);

        instructorHelper = new InstructorHelper(getApplicationContext());

        // Get the UI elements
        editTextUser = (EditText)this.findViewById(R.id.editTextUser);
        editTextPassword = (EditText)this.findViewById(R.id.editTextPassword);
        editTextName = (EditText)this.findViewById(R.id.editTextName);
        editTextEmail = (EditText)this.findViewById(R.id.editTextEmail);
        editTextPhone = (EditText)this.findViewById(R.id.editTextPhone);
    }

    public void onCreateClick(View view) {
        String user = editTextUser.getText().toString();
        String pass = editTextPassword.getText().toString();
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();

        Instructor instructor = new Instructor(user, name, pass, email, phone, isTa);
        instructorHelper.create(instructor);

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("currentInstructor", instructor.getUsername());
        editor.commit();

        Intent resultIntent = new Intent();
        setResult(MainActivity.RESULT_OK, resultIntent);
        finish();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonTA:
                if (checked) {
                    isTa = true;
                }
                break;
            case R.id.radioButtonProf:
                if (checked) {
                    isTa = false;
                }
        }
    }
}