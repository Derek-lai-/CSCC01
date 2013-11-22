package com.example.minutemadeproject.helpers;

import android.content.Context;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.dao.Dao;
import com.example.minutemadeproject.models.Assignment;

import java.sql.SQLException;
import java.util.List;

public class AssignmentHelper {

    private DatabaseHelper db;
    Dao<Assignment, Integer> assignmentDao;

    public AssignmentHelper(Context ctx){
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            assignmentDao = db.getAssignmentDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId(Assignment assignment){
        try {
            return assignmentDao.extractId(assignment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int create(Assignment assignment){
        try {
            return assignmentDao.create(assignment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Assignment assignment){
        try {
            return assignmentDao.update(assignment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Assignment assignment){
        try {
            return assignmentDao.delete(assignment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<Assignment> getAll(){
        try {
            return assignmentDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Assignment getAssignment(int id){
        try{
            return assignmentDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
