package com.example.minutemadeproject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "users")
public abstract class User {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField
	private String username;

    @DatabaseField
    private String password;

    @DatabaseField
	public String name;

    @DatabaseField
	public String email;

    @DatabaseField
	public String phone;

    User() {
        // Needed by OrmLite
    }

    public User(String username, String password, String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        // Should add encryption code here
        this.password = password;
    }
}

