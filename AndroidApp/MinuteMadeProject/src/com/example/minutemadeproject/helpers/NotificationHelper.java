package com.example.minutemadeproject.helpers;

import android.content.Context;
import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.db.DatabaseManager;
import com.example.minutemadeproject.models.Notification;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import java.util.List;

public class NotificationHelper {
	private DatabaseHelper db;
    Dao<Notification, Integer> notificationDao;
    
    public NotificationHelper(Context ctx){
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            notificationDao = db.getNotificationDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Notification, Integer> getNotificationDao(){
        try {
            return db.getNotificationDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int create(Notification notification){
        try {
            return notificationDao.create(notification);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Notification notification){
        try {
            return notificationDao.update(notification);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Notification notification){
        try {
            return notificationDao.delete(notification);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Notification> getAll(){
        try {
            return notificationDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Notification getNotification(int id){
        try{
            return notificationDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
    
