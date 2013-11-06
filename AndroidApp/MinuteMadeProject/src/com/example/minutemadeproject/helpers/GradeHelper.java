package com.example.minutemadeproject.helpers;

import android.content.Context;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.example.minutemadeproject.models.Grade;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class GradeHelper {
    private DatabaseHelper db;
    Dao<Grade, Integer> gradeDao;

    public GradeHelper(Context ctx){
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            gradeDao = db.getGradeDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Grade, Integer> getGradeDao(){
        try {
            return db.getGradeDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public List<Grade> getAll(){
        try {
            return gradeDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Grade getGrade(int id){
        try{
            return gradeDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
