package com.example.minutemadeproject.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.minutemadeproject.Assignment;
import com.example.minutemadeproject.AssignmentHelper;
import com.example.minutemadeproject.R;

public class AssignmentEditActivity extends Activity{

    public AssignmentHelper helper;
    Assignment assignment = null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentcreate);

        Intent i = getIntent();
        Bundle assignment = getIntent().getExtras();
        Integer assignmentId;
        if (assignment != null){
            assignmentId = assignment.getInt("assignment");
        }



    }
}
