package com.example.minutemadeproject;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "instructors")
public class Instructor extends User{

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
	public boolean isTA;

    @DatabaseField(foreign = true)
    private User user;

    @ForeignCollectionField
    ForeignCollection<Tutorial> tutorials;

    @ForeignCollectionField
	ForeignCollection<Course> courses;
	
}
