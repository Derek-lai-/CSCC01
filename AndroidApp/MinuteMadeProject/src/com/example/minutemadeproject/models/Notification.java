package com.example.minutemadeproject.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "notifications")
public class Notification {

	@DatabaseField(generatedId = true)
	public int id;

    @DatabaseField
    public String title;
    
    @DatabaseField
    public Integer hour;
    
    @DatabaseField
    public Integer minute;
    
    @DatabaseField
    public String content;
    
    @DatabaseField
    public Integer day;
    
    Notification(){
    	
    }
	
	public Notification(String title, Integer hour, Integer minute, String content, Integer day){
		this.title = title;
		this.hour = hour;
		this.minute = minute;
		this.content = content;
		this.day = day;
	}
	
	@Override
	public String toString(){
		return "Notification for " + title + " @ "+hour + ":"+ minute + " on "+ day;
	}
	
	
	
}
