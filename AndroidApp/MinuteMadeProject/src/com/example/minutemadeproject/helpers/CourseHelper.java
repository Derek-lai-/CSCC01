package com.example.minutemadeproject.helpers;

import android.content.Context;

import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class CourseHelper {
    private DatabaseHelper db;
    Dao<Course, Integer> courseDao;

    public CourseHelper(Context context) {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(context);
            courseDao = db.getCourseDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(Course course) {
        try {
            return courseDao.create(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Course course) {
        try {
            return courseDao.update(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Course course) {
        try {
            return courseDao.delete(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Course get(int id) {
        try {
            return courseDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Course> getAll() {
        try {
            return courseDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

