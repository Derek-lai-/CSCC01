package com.example.minutemadeproject.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

<<<<<<< HEAD
import java.util.Date;


@DatabaseTable(tableName = "assignments")
public class Assignment {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
    public Course course;

    @DatabaseField
    public String name;

    @DatabaseField
    public Date postDate;

    @DatabaseField
    public Date dueDate;

    @DatabaseField
    public double totalMark;

    @ForeignCollectionField
    public ForeignCollection<Grade> grades;

    Assignment() {
        // Needed by OrmLite
    }

    public Assignment(String name, Course course, Date postDate, Date dueDate, double totalMark) {
        this.name = name;
        this.course = course;
        this.postDate = postDate;
        this.dueDate = dueDate;
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return name + "for " + course.name + "due " + dueDate;
    }
=======
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Assignment extends ListActivity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//gets xml resources and stores into array
		String[] assignments = getResources().getStringArray(R.array.ass_ignment);
		
		//Binds resource array to ListAdapter
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.assignment_list, R.id.item, assignments));
		
		ListView lv = getListView();
		
		//listening for list item click
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				// selected item
				String agmt = ((TextView) view).getText().toString();
				
				//Launch new Activity on selecting List item
				Intent i = new Intent(getApplicationContext(), Assignment_view.class);
				//send data to new activity
				i.putExtra("assignment", agmt);
				startActivity(i);
				
			}
		});
	}
>>>>>>> beginning of new framework for assignment (redo)
}
