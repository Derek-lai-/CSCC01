package com.example.minutemadeproject;

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
    public Date postDate;

    @DatabaseField
    public Date dueDate;

    @DatabaseField
    public double totalMark;

    @ForeignCollectionField
    public ForeignCollection<Grade> grades;
}
