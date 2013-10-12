package com.example.minutemadeproject;

import java.util.ArrayList;

public class Lesson {
	int instructorId;
	ArrayList<String> topics = new ArrayList<String>();
	
	public Lesson(int iId){
		this.instructorId = iId;
	}
	
	public void addTopic(String topic){
		this.topics.add(topic);
	}
	
}
