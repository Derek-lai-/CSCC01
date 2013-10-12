package com.example.minutemadeproject;

import java.util.ArrayList;

public class Course {
	ArrayList<Tutorial> tuts = new ArrayList<Tutorial>();
	ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	String name;
	
	
	public Course(String name){
		this.name = name;
	}
	
	public void addTut(Tutorial t){
		this.tuts.add(t);		
	}
	
	public void removeTut(Tutorial t){
		this.tuts.remove(t);	
	}
}
