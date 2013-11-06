package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Course;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.minutemadeproject.R;

import java.util.ArrayList;
import java.util.List;


public class CourseActivity extends OrmLiteBaseListActivity<DatabaseHelper> {
    public ListView listView;
    private CourseHelper courseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);

        listView = (ListView)findViewById(R.id.list);
        courseHelper = new CourseHelper(getApplicationContext());

        List<Course> courses = courseHelper.getAll();


        ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this, R.layout.list_item, R.id.list_line1, courses);

        listView.setAdapter(adapter);
    }
}