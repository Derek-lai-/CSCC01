package com.example.minutemadeproject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "lessons")
public class Lesson {

    @DatabaseField(generatedId = true)
	public int id;

    @DatabaseField(foreign = true)
    public Instructor instructor;

    @DatabaseField
    public String topics;

    Lesson() {
        // Needed by OrmLite
    }

	public Lesson(Instructor instructor){
		this.instructor = instructor;
	}
}
