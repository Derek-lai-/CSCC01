package com.example.minutemadeproject;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "courses")
public class Course {

    @DatabaseField
    public int id;

    @DatabaseField
	public String name;

    @DatabaseField(foreign = true)
    public Instructor instructor;

    @ForeignCollectionField
    ForeignCollection<Tutorial> tutorials;

    @ForeignCollectionField
    ForeignCollection<Assignment> assignments;

    Course() {
        // Needed by OrmLite
    }

	public Course(String name, Instructor instructor){
		this.name = name;
        this.instructor = instructor;
	}

    @Override
    public String toString() {
        return name;
    }
}
