package com.example.minutemadeproject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "events")
public class Event {

    @DatabaseField(generatedId = true)
	public int id;

    @DatabaseField
	public String description;

    @DatabaseField
	public Date date;

    Event() {
        // Needed by OrmLite
    }

	public Event(int id, String des, Date d){
		this.id = id;
		this.description = des;
		this.date = d;				
	}
	
	public Event changeDescription(Event e, String des){
		e.description = des;
		return e;
	}
	
	public Event changeDate(Event e, Date d){
		e.date = d;
		return e;
	}
}
