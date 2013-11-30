package com.example.minutemadeproject.models;

import com.example.minutemadeproject.utils.Time;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "courses")
public class Course {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
	public String name;

    @DatabaseField(foreign = true)
    public Instructor instructor;

    @DatabaseField
    public String section;

    @DatabaseField
    public String room;

    @DatabaseField
    public int day;

    @DatabaseField
    public int startTime;

    @DatabaseField
    public int endTime;

    @ForeignCollectionField
    public ForeignCollection<Tutorial> tutorials;

    @ForeignCollectionField
    public ForeignCollection<Assignment> assignments;

    Course() {
        // Needed by OrmLite
    }

	public Course(Instructor instructor, String name, String section, int day, int startTime, int endTime, String room){
        this.instructor = instructor;
        this.name = name;
        this.section = section;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
	}

    public String startTime() {
        return Time.formatTime(this.startTime);
    }

    public String endTime() {
        return Time.formatTime(this.endTime);
    }

    @Override
    public String toString() {
        return name;
    }
}
