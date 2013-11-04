package com.example.minutemadeproject;

import java.util.List;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.dao.Dao;

import android.content.Context;
import android.database.SQLException;

public class InstructorHelper {
	private DatabaseHelper db;
	Dao<Instructor, Integer> instructorDao;

	public InstructorHelper(Context ctx){
		try{
			DatabaseManager dbManager = new DatabaseManager();
			db = dbManager.getDatabaseHelper(ctx);
			try {
				instructorDao = db.getInstructorDao();
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	
	}

	public int create(Instructor instructor) {
		try {
			try {
				return instructorDao.create(instructor);
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Instructor instructor) {
		try {
			try {
				return instructorDao.update(instructor);
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Instructor instructor) {
		try {
			try {
				return instructorDao.delete(instructor);
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List getAll() {
		try {
			try {
				return instructorDao.queryForAll();
			} catch (java.sql.SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Instructor getInstructor(int id) {
		try {
			try {
				return instructorDao.queryForId(id);
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
