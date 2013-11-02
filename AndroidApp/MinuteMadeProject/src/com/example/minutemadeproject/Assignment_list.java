package com.example.minutemadeproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
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

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                String text = ((TextView) view).getText().toString();
                Intent i = new Intent(getApplicationContext(), Assignment_view.class);
                i.putExtra("assignment", text);
                startActivity(i);
            }
        });

    }

}

