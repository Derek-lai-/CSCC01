package com.example.minutemadeproject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Assignment_view extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.assignment);
         
        TextView txtAssignment = (TextView) findViewById(R.id.item);
         
        Intent i = getIntent();
        // getting attached intent data
        String assignment = i.getStringExtra("assignment");
        // displaying selected product name
        txtAssignment.setText(assignment);
         
    }
}
