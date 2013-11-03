package com.example.minutemadeproject;

import java.util.ArrayList;

// class Lesson contains a lesson plan or other set of instructions
public class Lesson {
	int instructorId;
	// topics contain instructions
	String topic;
	String content;
	
	public Lesson(String otherTopic, String otherContent){
		this.topic = otherTopic;
		this.content = otherContent;
	}
	
	
	//edit the topic string
	public void editTopic(String otherTopic){
		this.topic = otherTopic;
	}
	
	public void editContent(){
		
	}
	
}
