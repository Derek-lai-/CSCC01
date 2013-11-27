package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.app.ListActivity;
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
import android.widget.Toast;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Tutorial;

import java.util.ArrayList;
import java.util.List;


public class CourseCreateActivity extends Activity{

    private CourseHelper courseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_create);

        courseHelper = new CourseHelper(getApplicationContext());
        final EditText editName = (EditText) findViewById(R.id.editCourseName);
        Button saveButton = (Button) findViewById(R.id.courseEditButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseName = editName.getText().toString();
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String currentUser = prefs.getString("CURRENT_USER", null);

                Instructor instructor = new InstructorHelper(getApplicationContext()).getByUser(currentUser);

                Course newCourse = new Course(courseName, instructor);
                courseHelper.create(newCourse);
                Toast toast = Toast.makeText(getApplicationContext(), "Successfully created " + courseName, Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
