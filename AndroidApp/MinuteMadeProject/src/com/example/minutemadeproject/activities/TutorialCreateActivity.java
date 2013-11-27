package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Tutorial;
import com.example.minutemadeproject.models.Instructor;


public class TutorialCreateActivity extends Activity{

    private TutorialHelper tutorialHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_create);

        tutorialHelper = new TutorialHelper(getApplicationContext());
        final EditText editName = (EditText) findViewById(R.id.editTutorialName);
        Button saveButton = (Button) findViewById(R.id.tutorialEditButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tutorialName = editName.getText().toString();
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String currentUser = prefs.getString("CURRENT_USER", null);
                CourseHelper courseHelper = new CourseHelper(getApplicationContext());
                Integer courseId = getIntent().getExtras().getInt("id");
                Course course = courseHelper.get(courseId);

                Instructor instructor = new InstructorHelper(getApplicationContext()).getByUser(currentUser);

                Tutorial newTutorial = new Tutorial(course, instructor, 1, 1111, 1111, tutorialName);
                tutorialHelper.create(newTutorial);
                Toast toast = Toast.makeText(getApplicationContext(), "Successfully created " + tutorialName, Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
