package com.example.minutemadeproject.db;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;


public class DatabaseManager {

    private DatabaseHelper databaseHelper = null;

    // Checks and returns a DatabaseHelper if it exists, else returns a fresh one.
    public DatabaseHelper getDatabaseHelper(Context context) {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    // Releases the current DatabaseHelper once usage is done.
    public void releaseDatabaseHelper(DatabaseHelper databaseHelper) {
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
