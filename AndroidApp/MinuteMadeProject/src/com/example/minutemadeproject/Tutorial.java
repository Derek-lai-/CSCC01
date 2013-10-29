package com.example.minutemadeproject;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "tutorials")
public class Tutorial {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
    public Course course;

    @DatabaseField(foreign = true)
    public Instructor TA;

    @DatabaseField
    public Date startTime;

    @DatabaseField
    public Date endTime;

    @ForeignCollectionField
    ForeignCollection<Student> students;

    Tutorial() {
        // Needed by OrmLite
    }

	public Tutorial(Course course, Instructor TA, Date startTime, Date endTime){
		this.course = course;
        this.TA = TA;
        this.startTime = startTime;
        this.endTime = endTime;
	}

    @Override
    public String toString() {
        return "Tutorial for " + course.name + " (" + startTime + " - " + endTime;
    }
}
