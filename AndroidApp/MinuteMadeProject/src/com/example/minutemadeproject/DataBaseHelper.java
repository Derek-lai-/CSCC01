package com.example.minutemadeproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "minuteMade.db";
    private static final int DATABASE_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Assignment.class);
            TableUtils.createTable(connectionSource, Course.class);
            TableUtils.createTable(connectionSource, Event.class);
            TableUtils.createTable(connectionSource, Instructor.class);
            TableUtils.createTable(connectionSource, Lesson.class);
            TableUtils.createTable(connectionSource, Schedule.class);
            TableUtils.createTable(connectionSource, Student.class);
            TableUtils.createTable(connectionSource, Tutorial.class);
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database.", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Assignment.class, true);
            TableUtils.dropTable(connectionSource, Course.class, true);
            TableUtils.dropTable(connectionSource, Event.class, true);
            TableUtils.dropTable(connectionSource, Instructor.class, true);
            TableUtils.dropTable(connectionSource, Lesson.class, true);
            TableUtils.dropTable(connectionSource, Schedule.class, true);
            TableUtils.dropTable(connectionSource, Student.class, true);
            TableUtils.dropTable(connectionSource, Tutorial.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);

            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop database.", e);
            throw new RuntimeException(e);
        }
    }
}
