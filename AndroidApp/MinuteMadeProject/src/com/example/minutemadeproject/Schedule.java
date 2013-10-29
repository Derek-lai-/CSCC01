package com.example.minutemadeproject;


import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "schedules")
public class Schedule {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
	public Instructor instructor;

    @ForeignCollectionField
    ForeignCollection<Event> events;

    Schedule() {
        // Needed by OrmLite
    }

    public Schedule(Instructor instructor){
		this.instructor = instructor;
	}
	
	public void addEvent(Event e){
		this.events.add(e);
	}
	
	public void deleteEvent(Event e){
		this.events.remove(e);	
	}
}
