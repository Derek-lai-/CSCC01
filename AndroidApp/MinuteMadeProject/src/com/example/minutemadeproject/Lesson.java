package com.example.minutemadeproject;

import java.util.ArrayList;

// class Lesson contains a lesson plan or other set of instructions
public class Lesson {
	int instructorId;
	// topics contain instructions
	ArrayList<String> topics = new ArrayList<String>();
	
	public Lesson(int iId){
		this.instructorId = iId;
	}
	
	//add a topic that a TA want to cover in the tutorial.
	//return 1 when add success,otherwise return 0;
	public int addTopic(String topic){
		//
		if(this.topics.contains(topic)){
			return 0;
		}
		else{
			this.topics.add(topic);
			return 1;
		}
	}
	
	//remove
	//return 1 when remove success,otherwise return 0;
	public int removeTopic(String topic){
		if(this.topics.contains(topic)){
			this.topics.remove(topic);
			return 1;
		}
		else{
			return 0;
		}
	}
	
	//edit the topic string
	//return 1 on success, 0 on fail
	public int editTopic(String topic, String topicOther){
		if(this.topics.contains(topic)){
			this.topics.set(this.topics.indexOf(topic), topicOther);
			return 1;
		}
		else{
			return 0;
		}
	}
	
	//add the lesson plan to the database
	public int update(){
		return 0;
	}
	
	//get the lesson plan from the database
	public int getLessonPlan(){
		return 0;
	}
	
}
