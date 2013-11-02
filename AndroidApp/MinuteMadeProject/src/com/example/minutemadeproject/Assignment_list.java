package com.example.minutemadeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.example.minutemadeproject.Assignment;

public class Assignment_list extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_list);
        Assignment a = new Assignment();

        a.initList();
        // get listview part from layout
        ListView lv = (ListView) findViewById(R.id.item);

        // adapter accepts parameters
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, a.assignmentList, android.R.layout.simple_list_item_1,
                new String[] {"assignment"}, new int[] {android.R.id.text1});
        lv.setAdapter(simpleAdapter);

    }
}

