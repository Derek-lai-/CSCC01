package com.example.minutemadeproject;

import android.content.Context;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class StudentHelper {
    private DatabaseHelper db;
    Dao<Student, Integer> studentDao;

    public StudentHelper(Context ctx){
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getDatabaseHelper(ctx);
            studentDao = db.getStudentDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Student,Integer> getGradeDao(){
        try {
            return db.getStudentDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(Student student){
        try {
            return studentDao.create(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Student student){
        try {
            return studentDao.update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Student student){
        try {
            return studentDao.delete(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Student> getAll(){
        try {
            return studentDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudent(int id){
        try{
            return studentDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
