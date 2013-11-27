package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.TutorialHelper;
import com.example.minutemadeproject.models.Course;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.models.Tutorial;

import java.util.List;


public class CourseActivity extends ListActivity {
    public ListView listView;
    private CourseHelper courseHelper;
    private ArrayAdapter<Course> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);
    }

    @Override
    public void onResume() {
        super.onResume();
        listView = getListView();
        courseHelper = new CourseHelper(getApplicationContext());


        final List<Course> courses = courseHelper.getAll();

        adapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, courses);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), CourseEditActivity.class);
                intent.putExtra("id", courses.get(i).id);
                startActivity(intent);
            }
        });

        Button addCourseButton = (Button) findViewById(R.id.addCourseButton);
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CourseCreateActivity.class);
                startActivity(intent);
            }
        });
    }
}