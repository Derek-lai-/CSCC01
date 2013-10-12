package com.example.minutemadeproject;

import java.util.ArrayList;

public class Schedule {
	ArrayList<Event> events = new ArrayList<Event>();
	int instructorId;
	
	public Schedule(int id){
		this.instructorId = id;
	}
	
	public void addEvent(Event e){
		this.events.add(e);
	}
	
	public void deleteEvent(Event e){
		this.events.remove(e);	
	}
}
