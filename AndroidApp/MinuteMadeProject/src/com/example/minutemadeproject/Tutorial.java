package com.example.minutemadeproject;

import java.util.ArrayList;
import java.util.Date;

public class Tutorial {
	ArrayList<Student> students = new ArrayList<Student>();
	Date timeslot = new Date();
	int courseId;
	
	public Tutorial(int courseId){
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
