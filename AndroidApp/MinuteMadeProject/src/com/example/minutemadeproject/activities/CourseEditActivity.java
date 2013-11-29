package com.example.minutemadeproject.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
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


public class CourseEditActivity extends ListActivity{

    private CourseHelper courseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_edit);
    }

    public void onResume() {
        super.onResume();

        courseHelper = new CourseHelper(getApplicationContext());
        Intent intent = getIntent();
        final EditText editName = (EditText) findViewById(R.id.editCourseName);
        Button saveButton = (Button) findViewById(R.id.courseEditButton);
        Button addTutButton = (Button) findViewById(R.id.addTutorialButton);
        final Course course;

        if (intent.hasExtra("id")) {
            Integer courseId = intent.getExtras().getInt("id");
            course = courseHelper.get(courseId);

            editName.setText(course.name);

            ListView listView = getListView();
            final List<Tutorial> tutorials = new ArrayList<Tutorial>(course.tutorials);

            ArrayAdapter<Tutorial> adapter = new ArrayAdapter<Tutorial>(this, android.R.layout.simple_list_item_1, tutorials);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(view.getContext(), TutorialEditActivity.class);
                    intent.putExtra("tutID", tutorials.get(i).id);
                    intent.putExtra("courseID", course.id);
                    startActivity(intent);
                }
            });

        } else {
            course = null;
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.courseEditButton:
                        String courseName = editName.getText().toString();
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        String currentUser = prefs.getString("CURRENT_USER", null);

                        Instructor instructor = new InstructorHelper(getApplicationContext()).getByUser(currentUser);

                        if (course == null) {
                            Course newCourse = new Course(courseName, instructor);
                            courseHelper.create(newCourse);
                        } else {
                            course.name = courseName;
                            courseHelper.update(course);
                        }
                        Toast toast = Toast.makeText(getApplicationContext(), "Successfully saved " + courseName, Toast.LENGTH_SHORT);
                        toast.show();
                        finish();
                        break;
                    case R.id.addTutorialButton:
                        Intent intent = new Intent(view.getContext(), TutorialEditActivity.class);
                        intent.putExtra("courseID", course.id);
                        startActivity(intent);
                        break;
                }
            }
        };

        saveButton.setOnClickListener(onClickListener);
        addTutButton.setOnClickListener(onClickListener);
    }
}
