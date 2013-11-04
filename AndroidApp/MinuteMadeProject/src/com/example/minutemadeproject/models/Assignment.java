package com.example.minutemadeproject.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "assignments")
public class Assignment {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
    public Course course;

    @DatabaseField
    public String name;

    @DatabaseField
    public String tutorial;

    @DatabaseField
    public String description;

    @DatabaseField
    public Date postDate;

    @DatabaseField
    public Date dueDate;

    @DatabaseField
    public double totalMark;

    @ForeignCollectionField
    public ForeignCollection<Grade> grades;

    Assignment() {
        // Needed by OrmLite
    }

    public Assignment(String name, String tutorial, String description, Course course, Date postDate, Date dueDate, double totalMark) {
        this.name = name;
        this.course = course;
        this.tutorial = tutorial;
        this.description = description;
        this.postDate = postDate;
        this.dueDate = dueDate;
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return name + "for " + course.name + "due " + dueDate;
    }

}
