package com.example.minutemadeproject.helpers;

import android.content.Context;

import com.example.minutemadeproject.models.Tutorial;
import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class TutorialHelper {
    private DatabaseHelper db;
    Dao<Tutorial, Integer> tutorialDao;

    public TutorialHelper(Context context) {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(context);
            tutorialDao = db.getTutorialDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(Tutorial tutorial) {
        try {
            return tutorialDao.create(tutorial);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Tutorial tutorial) {
        try {
            return tutorialDao.update(tutorial);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Tutorial tutorial) {
        try {
            return tutorialDao.delete(tutorial);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Tutorial> findMatch(String field, String value){
        try{
            return tutorialDao.queryForEq(field, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tutorial get(int id) {
        try {
            return tutorialDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAll() {
        try {
            return tutorialDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
