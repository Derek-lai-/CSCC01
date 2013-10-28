package com.example.minutemadeproject;

import java.util.ArrayList;


public class Instructor extends User{
	
	public Instructor(String u, String n, String e, String p) {
		super(u, n, e, p);
		// TODO Auto-generated constructor stub
	}
	boolean isTa;
	ArrayList<Tutorial> tuts = new ArrayList<Tutorial>();
	ArrayList<Course> courses = new ArrayList<Course>();
	
}
