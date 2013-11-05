package com.example.minutemadeproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minutemadeproject.AssignmentHelper;
import com.example.minutemadeproject.R;

import com.example.minutemadeproject.Assignment;
import java.util.List;

public class AssignmentListActivity extends Activity{

    private List<Assignment> assignments;
    private List<String> aNames;
    public AssignmentHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentlist);
        //fills local variables with items from database
        getItems();
        //sets up array adapter with assignment names from aNames
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.assignmentlist
                , aNames);
        //fills layout
        ListView lv = (ListView) findViewById(R.id.assignmentlist);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //gets name of item clicked
                String text = ((TextView) view).getText().toString();
                //creates new intent object pointing to new class to open
                Intent i = new Intent(getApplicationContext(), AssignmentViewActivity.class);
                //Retrieves index of the assignment name
                int index = aNames.indexOf(text);
                //gets the assignment object
                Assignment a = assignments.get(index);
                //get assignment database id
                int aId = a.id;
                //packages id to pass to next activity
                i.putExtra("assignment" , aId);
                //starts new activity
                startActivity(i);
            }
        });
    }


	public void getItems(){
        helper = new AssignmentHelper(this);
        assignments = helper.getAll();
        //gets name of all assignment in list of assignment objects
        for (Assignment a: assignments){
            aNames.add(a.name);
        }
    }

}

