package com.example.minutemadeproject.models;

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

    public String topic;
    public String content;
    
    Lesson() {
        // Needed by OrmLite
    }

	public Lesson(Instructor instructor, String title, String topics){
        this.title = title;
		this.instructor = instructor;
        this.topics = topics;
        this.topic = title;
        this.content = topics;
	}
	
	public Lesson(String otherTopic, String otherContent){
        this.topic = otherTopic;
        this.content = otherContent;
	}

    @Override
    public String toString() {
        return title + " by " + instructor;
    }
}
