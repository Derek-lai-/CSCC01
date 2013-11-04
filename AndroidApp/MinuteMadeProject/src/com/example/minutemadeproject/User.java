package com.example.minutemadeproject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "users")
public abstract class User {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
	private String username;

    @DatabaseField
    private String password;
    
    @DatabaseField
	private String name;

    @DatabaseField
	private String email;

    @DatabaseField
	private String phone;

    User() {
        // Needed by OrmLite
    }

    public User(String username, String password, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    public String getUsername(){
    	return username;
    }
    
    public String getPassword(){
    	return password;
    }
    public String getName(){
    	return name;
    }
    
    public String getEmail(){
    	return email;
    }
    
    public String phone(){
    	return phone;
    }
}

