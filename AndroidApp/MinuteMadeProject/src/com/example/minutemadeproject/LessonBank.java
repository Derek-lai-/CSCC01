package com.example.minutemadeproject;

import java.util.ArrayList;

public class LessonBank {
	private ArrayList<Lesson> lessons;
	private ArrayList<String> topics;
	
	public LessonBank(){
		lessons = new ArrayList<Lesson>();
		topics = new ArrayList<String>();
	}
	
	public void addLesson(Lesson otherLesson){
		lessons.add(otherLesson);
		topics.add(otherLesson.topic);
	}
	
	public void removeLesson(Lesson otherLesson){
		lessons.remove(otherLesson);
	}
	
	public ArrayList<Lesson> getLessons(){
		return this.lessons;
	}
	
	public ArrayList<String> getTopics(){
		return this.topics;
	}
}