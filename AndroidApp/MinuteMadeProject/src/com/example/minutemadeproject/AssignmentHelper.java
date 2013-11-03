package com.example.minutemadeproject;

import android.content.Context;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import org.w3c.dom.Comment;

import java.sql.SQLException;
import java.util.List;

public class AssignmentHelper {

    private DatabaseHelper db;
    Dao<Assignment, Integer> assignmentDao;

    public void AssignmentRepository(Context ctx){
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getDatabaseHelper(ctx);
            assignmentDao = db.getAssignmentDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


    public List getAll(){
        try {
            return assignmentDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
