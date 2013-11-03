package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.minutemadeproject.AssignmentHelper;
import com.example.minutemadeproject.R;
import com.example.minutemadeproject.activities.AssignmentViewActivity;

import java.util.ArrayList;

public class AssignmentListActivity extends Activity{

    private ArrayList assignments;
    private AssignmentHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentlist);
        // get listview part from layout
        ListView lv = (ListView) findViewById(R.id.item);
        helper = new AssignmentHelper(this);
        assignments = (ArrayList)helper.getAll();

        // adapter accepts parameters
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, assignments);
        lv.setAdapter(simpleAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                String text = ((TextView) view).getText().toString();
                Intent i = new Intent(getApplicationContext(), AssignmentViewActivity.class);
                i.putExtra("assignment", text);
                startActivity(i);
            }
        });

    }

}

