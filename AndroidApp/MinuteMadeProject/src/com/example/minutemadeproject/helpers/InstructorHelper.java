package com.example.minutemadeproject.helpers;

import android.content.Context;

import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class InstructorHelper {
    private DatabaseHelper db;
    Dao<Instructor, Integer> instructorDao;

    public InstructorHelper(Context context) {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(context);
            instructorDao = db.getInstructorDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(Instructor instructor) {
        try {
            return instructorDao.create(instructor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Instructor instructor) {
        try {
            return instructorDao.update(instructor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Instructor instructor) {
        try {
            return instructorDao.delete(instructor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Instructor get(int id) {
        try {
            return instructorDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAll() {
        try {
            return instructorDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Instructor getByUser(String username) {
        try {
            List<Instructor> matching = instructorDao.queryForEq("username", username);
            return matching.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}