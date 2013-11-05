package com.example.minutemadeproject.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "tutorials")
public class Tutorial {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
    public Course course;

    @DatabaseField(foreign = true)
    public Instructor TA;

    @DatabaseField
    public int day;

    @DatabaseField
    public int startTime;

    @DatabaseField
    public int endTime;

    @ForeignCollectionField
    ForeignCollection<Student> students;

    Tutorial() {
        // Needed by OrmLite
    }

	public Tutorial(Course course, Instructor TA, int day, int startTime, int endTime) {
		this.course = course;
        this.TA = TA;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
	}

    public String getDay() {

        //String we will return
        String dayString = "";

        //Switch to convert days from int to string formats
        switch(this.day) {
            case 0: dayString = "Monday";
                break;
            case 1: dayString = "Tuesday";
                break;
            case 2: dayString = "Wednesday";
                break;
            case 3: dayString = "Thursday";
                break;
            case 4: dayString = "Friday";
                break;
            case 5: dayString = "Saturday";
                break;
            case 6: dayString = "Sunday";
                break;
        }

        return dayString;
    }

    @Override
    public String toString() {
        return "Tutorial for " + course.name + " (" + startTime + " - " + endTime;
    }
}
