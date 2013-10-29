package com.example.minutemadeproject;

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

    Student() {
        // Needed by OrmLite
    }

	public Student(String name, String email, int number){
		this.name = name;
		this.email = email;
        this.number = number;
	}

    @Override
    public String toString() {
        return name + " (" + number + ") - " + email;
    }
}
