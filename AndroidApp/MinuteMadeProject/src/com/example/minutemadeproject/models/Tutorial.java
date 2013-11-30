package com.example.minutemadeproject.models;

import com.example.minutemadeproject.utils.Time;
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
    public String section;

    @DatabaseField
    public int startTime;

    @DatabaseField
    public int endTime;

    @ForeignCollectionField
    ForeignCollection<Student> students;

    Tutorial() {
        // Needed by OrmLite
    }

	public Tutorial(Course course, Instructor TA, int day, int startTime, int endTime, String section) {
		this.course = course;
        this.TA = TA;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.section = section;
	}

    public String getDay() {

        //String we will return
        String dayString = "";

        //Switch to convert days from int to string formats
        switch(this.day) {
            case 1:
                dayString = "Sunday";
                break;
            case 2:
                dayString = "Monday";
                break;
            case 3:
                dayString = "Tuesday";
                break;
            case 4:
                dayString = "Wednesday";
                break;
            case 5:
                dayString = "Thursday";
                break;
            case 6:
                dayString = "Friday";
                break;
            case 7:
                dayString = "Saturday";
                break;
        }
        return dayString;
    }

    public String startTime() {
        return Time.formatTime(this.startTime);
    }

    public String endTime() {
        return Time.formatTime(this.endTime);
    }

    @Override
    public String toString() {
        return this.section + " (" + this.startTime() + "-" + this.endTime() + ")";
    }
}
