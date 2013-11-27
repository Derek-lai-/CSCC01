package com.example.minutemadeproject.models;

import java.util.ArrayList;
import java.util.Iterator;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "group")
public class Group {
	
	@DatabaseField(generatedId = true)
	public int id;
	
	@DatabaseField(foreign = true)
	public Tutorial tut;
	
	@ForeignCollectionField
    ForeignCollection<Student> students;
	
	Group(){
		// Needed by OrmLite
	}
	
	public Group(Tutorial t, ArrayList<Student> student){
		this.tut = t;
		this.students = (ForeignCollection<Student>) student;	
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}
	public void removeStudent(Student s){
		this.students.remove(s);
	}
}
