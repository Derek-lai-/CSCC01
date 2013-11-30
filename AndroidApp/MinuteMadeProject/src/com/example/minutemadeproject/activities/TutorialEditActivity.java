package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Tutorial;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.utils.Time;

import java.util.Calendar;


public class TutorialEditActivity extends Activity{

    private TutorialHelper tutorialHelper;
    private EditText editName;
    private TextView startTimeView;
    private TextView endTimeView;
    private Spinner daySpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_edit);

        Tutorial tutorial;

        tutorialHelper = new TutorialHelper(getApplicationContext());
        editName = (EditText) findViewById(R.id.editTutorialName);
        startTimeView = (TextView) findViewById(R.id.textViewStart);
        endTimeView = (TextView) findViewById(R.id.textViewEnd);
        daySpinner = (Spinner) findViewById(R.id.spinnerDay);
        Button saveButton = (Button) findViewById(R.id.tutorialEditButton);
        Button startTimeButton = (Button) findViewById(R.id.buttonStartTime);
        Button endTimeButton = (Button) findViewById(R.id.buttonEndTime);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.day_array, android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(spinnerAdapter);

        Intent intent = getIntent();
        if (intent.hasExtra("tutID")) {
            Integer tutID = intent.getExtras().getInt("tutID");
            tutorial = tutorialHelper.get(tutID);

            editName.setText(tutorial.section);
            startTimeView.setText(tutorial.startTime());
            endTimeView.setText(tutorial.endTime());
            daySpinner.setSelection(tutorial.day - 1);
        }

        startTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog tPD;
                tPD = new TimePickerDialog(TutorialEditActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        int hour = selectedHour;
                        int minute = selectedMinute;
                        startTimeView.setText(Time.stringifyTime(hour, minute));
                    }
                }, hour, minute, false);
                tPD.setTitle("Select Start Time");
                tPD.show();
            }
        });

        endTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog tPD;
                tPD = new TimePickerDialog(TutorialEditActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        int hour = selectedHour;
                        int minute = selectedMinute;
                        endTimeView.setText(Time.stringifyTime(hour, minute));
                    }
                }, hour, minute, false);
                tPD.setTitle("Select End Time");
                tPD.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tutorialName = editName.getText().toString();
                int startTime = Time.intifyTime(startTimeView.getText().toString());
                int endTime = Time.intifyTime(endTimeView.getText().toString());
                int day = daySpinner.getSelectedItemPosition() + 1; // Plus 1 because position begins at 0
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String currentUser = prefs.getString("CURRENT_USER", null);

                CourseHelper courseHelper = new CourseHelper(getApplicationContext());
                Integer courseId = getIntent().getExtras().getInt("courseID");
                Course course = courseHelper.get(courseId);

                Instructor instructor = new InstructorHelper(getApplicationContext()).getByUser(currentUser);

                Tutorial newTutorial = new Tutorial(course, instructor, day, startTime, endTime, tutorialName);
                tutorialHelper.create(newTutorial);
                Toast toast = Toast.makeText(getApplicationContext(), "Successfully updated " + tutorialName, Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
