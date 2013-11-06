package com.example.minutemadeproject.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.db.DatabaseHelper;
import com.example.minutemadeproject.models.Instructor;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;


public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    public int RESULT_CODE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if first time running
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean isDebuggable =  ( 0 != ( getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE ) );
        if (isDebuggable) {
            SharedPreferences.Editor editor = settings.edit();
            editor.remove("currentInstructor");
            editor.commit();
        }
        String currentInstructor = settings.getString("currentInstructor", null);
        RESULT_CODE = 1;
        if (currentInstructor == null) {
            // Run the SetUpActivity on first run
            Intent i = new Intent(this, SetUpActivity.class);
            startActivityForResult(i, RESULT_CODE);
        }

        setContentView(R.layout.main);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CODE) {
            SharedPreferences settings = getSharedPreferences("prefs", 0);
            String currentInstructor = settings.getString("currentInstructor", null);
            Log.i("Current Instructor", currentInstructor);
            String content = "Hello " + currentInstructor + "!";
            Toast toast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}