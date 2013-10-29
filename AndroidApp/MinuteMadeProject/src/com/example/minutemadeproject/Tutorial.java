package com.example.minutemadeproject;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "tutorials")
public class Tutorial {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
    public String courseId;

    @DatabaseField
    public Date timeslot;

    @ForeignCollectionField
    ForeignCollection<Student> students;

	public Tutorial(String courseId){
		this.courseId = courseId;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	
	}
	public Student getStudent(String Name){
		Student s = null;
		
		return s;
	}
	
}
