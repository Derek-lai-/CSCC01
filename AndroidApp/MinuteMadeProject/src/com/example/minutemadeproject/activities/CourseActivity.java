package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.models.Course;
import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.minutemadeproject.R;

import java.util.List;


public class CourseActivity extends OrmLiteBaseListActivity {
    public ListView listView;
    private CourseHelper courseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);

        listView = (ListView)findViewById(R.id.course_list);
        courseHelper = new CourseHelper(getApplicationContext());

        List<Course> courses = courseHelper.getAll();
    }
}
