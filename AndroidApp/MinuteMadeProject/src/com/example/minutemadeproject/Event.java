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
	public Date startDate;

    @DatabaseField
    public Date endDate;

    @DatabaseField(foreign = true)
    public Schedule schedule;

    Event() {
        // Needed by OrmLite
    }

	public Event(String description, Date startDate, Date endDate, Schedule schedule) {
		this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = schedule;
	}

    @Override
    public String toString() {
        return "(" + startDate + "-" + endDate + ") " + description;
    }
}
