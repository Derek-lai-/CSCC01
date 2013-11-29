package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.StudentHelper;
import com.example.minutemadeproject.models.Student;

import java.util.List;

public class AssignmentStudentListActivity extends Activity{

    private List<Student> students;
    private List<String> names;
    private List<Integer> studentId;
    private StudentHelper helper;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_student);
        
        getItems();
        
        ListView lv = (ListView) findViewById(R.id.assignmentstudent);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.assignment_student, studentId);
        lv.setAdapter(adapter);
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
            	//gets name of item clicked
                String text = ((TextView) view).getText().toString();
                //creates new intent object pointing to new class to open
                Intent i = new Intent(getApplicationContext(), GradesActivity.class);
                //Retrieves index of the student name
                int index = names.indexOf(text);
                //gets a student object
                Student s = students.get(index);
                //get assignment database id
                int studentId = s.number;
                //packages id to pass to next activity
                i.putExtra("student" , studentId);
                //starts new activity
                startActivity(i);
            }
        });

    }
    public void getItems(){
        helper = new StudentHelper(this);
        students = helper.getAll();
        //gets name of all assignment in list of assignment objects
        for (Student s: students){
            studentId.add(s.number);
            names.add(s.name);
        }
    }
}

