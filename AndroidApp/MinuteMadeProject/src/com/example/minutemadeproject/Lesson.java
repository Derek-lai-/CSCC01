package com.example.minutemadeproject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "lessons")
public class Lesson {

    @DatabaseField(generatedId = true)
	public int id;

    @DatabaseField
    public String title;

    @DatabaseField(foreign = true)
    public Instructor instructor;

    @DatabaseField
    public String topics;

    Lesson() {
        // Needed by OrmLite
    }

	public Lesson(Instructor instructor, String title, String topics){
        this.title = title;
		this.instructor = instructor;
        this.topics = topics;
	}

    @Override
    public String toString() {
        return title + " by " + instructor;
    }
}
