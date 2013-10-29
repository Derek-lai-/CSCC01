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

    @ForeignCollectionField
    ForeignCollection<Tutorial> tutorials;

    @ForeignCollectionField
    ForeignCollection<Assignment> assignments;

    Course() {
        // Needed by OrmLite
    }

	public Course(String name){
		this.name = name;
	}

    @Override
    public String toString() {
        return name;
    }
}
