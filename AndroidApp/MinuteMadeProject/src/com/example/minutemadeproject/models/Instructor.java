package com.example.minutemadeproject.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "instructors")
public class Instructor extends User{

    @DatabaseField
	public boolean isTA;

    @DatabaseField(foreign = true)
    private User user;

    @ForeignCollectionField
    ForeignCollection<Tutorial> tutorials;

    @ForeignCollectionField
	ForeignCollection<Course> courses;

    Instructor() {
        // Needed by OrmLite
    }

    public Instructor(
            String username,
            String name,
            String password,
            String email,
            String phone,
            boolean isTA) {

        setUsername(username);
        setPassword(password);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isTA = isTA;
    }

    @Override
    public String toString() {
        if (isTA) {
            return this.name + " - TA";
        } else {
            return this.name + " - Professor";
        }
    }
}
