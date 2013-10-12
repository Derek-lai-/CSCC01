package com.example.minutemadeproject;
import java.util.Date;


public class Event {
	int eventId;
	String description;
	Date date = new Date();
	
	public Event(int id, String des, Date d){
		this.eventId = id;
		this.description = des;
		this.date = d;				
	}
	
	public Event editEventDescription(Event e, String des){
		e.description = des;
		return e;
	}
	
	public Event changeDate(Event e, Date d){
		e.date = d;
		return e;
	}
}
