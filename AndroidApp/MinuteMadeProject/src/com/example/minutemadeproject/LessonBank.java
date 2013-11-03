package com.example.minutemadeproject;

import java.util.ArrayList;

public class LessonBank {
	private ArrayList<Lesson> lessons;
	
	public LessonBank(){
		lessons = new ArrayList<Lesson>();
	}
	
	public void addLesson(Lesson otherLesson){
		lessons.add(otherLesson);
		
	}
	
	public void removeLesson(Lesson otherLesson){
		lessons.remove(otherLesson);
	}
	
	public ArrayList<Lesson> getLessons(){
		return this.lessons;
	}
}
