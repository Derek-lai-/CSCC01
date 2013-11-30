package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Tutorial;
import com.example.minutemadeproject.utils.Time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CourseCreateActivity extends Activity{

    private CourseHelper courseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_create);

       courseHelper = new CourseHelper(getApplicationContext());
        Intent intent = getIntent();
        final EditText editName = (EditText) findViewById(R.id.editCourseName);
        final EditText editSection = (EditText) findViewById(R.id.editCourseSection);
        final EditText editRoom = (EditText) findViewById(R.id.editCourseRoom);
        final TextView startTimeView = (TextView) findViewById(R.id.textViewStart);
        final TextView endTimeView = (TextView) findViewById(R.id.textViewEnd);
        final Spinner daySpinner = (Spinner) findViewById(R.id.spinnerDay);
        Button startTimeButton = (Button) findViewById(R.id.buttonStartTime);
        Button endTimeButton = (Button) findViewById(R.id.buttonEndTime);
        Button saveButton = (Button) findViewById(R.id.courseEditButton);
        Button addTutButton = (Button) findViewById(R.id.addTutorialButton);
        final Course course;

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.day_array, android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(spinnerAdapter);

        startTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog tPD;
                tPD = new TimePickerDialog(CourseCreateActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                tPD = new TimePickerDialog(CourseCreateActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                String courseName = editName.getText().toString();
                String courseSection = editSection.getText().toString();
                String courseRoom = editRoom.getText().toString();
                int startTime = Time.intifyTime(startTimeView.getText().toString());
                int endTime = Time.intifyTime(endTimeView.getText().toString());
                int day = daySpinner.getSelectedItemPosition() + 1; // Plus 1 because position begins at 0

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String currentUser = prefs.getString("CURRENT_USER", null);
                Instructor instructor = new InstructorHelper(getApplicationContext()).getByUser(currentUser);

                Course newCourse = new Course(instructor, courseName, courseSection, day, startTime, endTime, courseRoom);
                courseHelper.create(newCourse);
                Toast toast = Toast.makeText(getApplicationContext(), "Successfully saved " + courseName, Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
