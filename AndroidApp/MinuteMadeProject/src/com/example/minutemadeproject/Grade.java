package com.example.minutemadeproject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "grades")
public class Grade {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
    public Assignment assignment;

    @DatabaseField(foreign = true)
    public Student student;

    @DatabaseField
    public double mark;
}
