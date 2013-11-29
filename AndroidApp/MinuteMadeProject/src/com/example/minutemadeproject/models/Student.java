package com.example.minutemadeproject.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "students")
public class Student {

    @DatabaseField(id = true)
    public int number;

    @DatabaseField
	public String name;

    @DatabaseField
	public String email;

    @DatabaseField(foreign = true)
    public Tutorial tutorial;
    
    @DatabaseField(foreign = true)
    public Group group;

    @DatabaseField
    public String utorid;
    
    Student() {
        // Needed by OrmLite
    }

	public Student(String name, String email, int number, String utorid, Tutorial tutorial, Group group) {
		this.name = name;
		this.email = email;
        this.number = number;
        this.tutorial = tutorial;
        this.group = group;
        this.utorid = utorid;
	}

    @Override
    public String toString() {
        return name + " (" + number + ") - " + email;
    }
}
