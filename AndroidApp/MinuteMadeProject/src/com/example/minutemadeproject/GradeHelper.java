package com.example.minutemadeproject;

import android.content.Context;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import org.w3c.dom.Comment;

import java.sql.SQLException;
import java.util.List;

public class GradeHelper {
    private DatabaseHelper db;
    Dao<Grade, Integer> gradeDao;

    public void AssignmentRepository(Context ctx){
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getDatabaseHelper(ctx);
            gradeDao = db.getGradeDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(Grade grade){
        try {
            return gradeDao.create(grade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Grade grade){
        try {
            return gradeDao.update(grade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Grade grade){
        try {
            return gradeDao.delete(grade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List getAll(){
        try {
            return gradeDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
