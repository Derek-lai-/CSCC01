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
	private String name;

    @DatabaseField
	private String email;

    @DatabaseField
	private String phone;

    User() {
        // Needed by OrmLite
    }

    public User(String username, String name, String email, String phone) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}

