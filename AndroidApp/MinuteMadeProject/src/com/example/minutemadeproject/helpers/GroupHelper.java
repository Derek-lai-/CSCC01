package com.example.minutemadeproject.helpers;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Group;
import com.j256.ormlite.dao.Dao;

public class GroupHelper {
	private DatabaseHelper db;
    Dao<Group, Integer> groupDao;

    public GroupHelper(Context context) {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(context);
            groupDao = db.getGroupDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(Group group) {
        try {
            return groupDao.create(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Group group) {
        try {
            return groupDao.update(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Group group) {
        try {
            return groupDao.delete(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Group get(int id) {
        try {
            return groupDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAll() {
        try {
            return groupDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
