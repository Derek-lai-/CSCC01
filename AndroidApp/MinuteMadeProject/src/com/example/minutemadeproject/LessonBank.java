package com.example.minutemadeproject;

import com.example.minutemadeproject.models.Lesson;

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
	
	public void edit(String topicToEdit, String contentToEdit){
		for(Lesson item:lessons){
			if(item.topic.contentEquals(topicToEdit)){
				item.content = contentToEdit;
			}
		}
		
		for(String item:topics){
			if(item.contentEquals(topicToEdit)){
				item = topicToEdit;
			}
		}
	}
	
	public void edit(int position, String topicToEdit, String contentToEdit){
		lessons.get(position).topic = topicToEdit;
		lessons.get(position).content = contentToEdit;
		topics.set(position, topicToEdit);
	}
	
	public void remove(int position){
		lessons.remove(position);
		topics.remove(position);
	}
}
