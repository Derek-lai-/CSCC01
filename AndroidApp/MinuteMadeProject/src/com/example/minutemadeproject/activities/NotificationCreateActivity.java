package com.example.minutemadeproject.activities;

import java.util.Calendar;

import com.example.minutemadeproject.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;
import android.widget.Toast;

public class NotificationCreateActivity extends Activity{

    Integer hour, minute;
    TextView clock;
    String name;
    Boolean mon = false,tues = false,wed = false,thurs = false,fri = false,sat = false,sun = false;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_notification);

        final EditText editName = (EditText) findViewById(R.id.editName);
        clock = (TextView) findViewById(R.id.clock);
        Button saveNote = (Button) findViewById(R.id.saveButton);

        saveNote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                name = editName.getText().toString();
            }
        });

        clock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                hour = currentTime.get(Calendar.HOUR_OF_DAY);
                minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog tPD;
                tPD = new TimePickerDialog(NotificationCreateActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        String time = "";
                        if (hour > 12){
                            String h = String.valueOf(hour - 12);
                            if (hour - 12 < 10) {
                                time += "0" + h;
                            }else{
                                time += h;
                            }
                            time += ":";
                            time += (minute);
                            time += " PM";
                        }else{
                            String h = String.valueOf(hour);
                            if (hour - 12 < 10) {
                                time += "0" + h;
                            }else{
                                time += h;
                            }
                            time += ":";
                            time += (minute);
                            time += " AM";
                        };
                        clock.setText(time);
                    }
                }, hour, minute, false);
                tPD.setTitle("Select Time");
                tPD.show();
            }
        });

    }

    public void onCheckboxChecked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.selectMon:
                if (checked){
                    mon = true;
                }else{
                    mon = false;
                }
                break;

            case R.id.selectTues:
                if (checked){
                tues = true;
                }else{
                tues = false;
                }
                break;

            case R.id.selectWed:
                if (checked){
                    wed = true;
                }else{
                    wed = false;
                }
                break;

            case R.id.selectThurs:
                if (checked){
                    thurs = true;
                }else{
                    thurs = false;
                }
                break;

            case R.id.selectFri:
                if (checked){
                    fri = true;
                }else{
                    fri = false;
                }
                break;

            case R.id.selectSat:
                if (checked){
                    sat = true;
                }else{
                    sat = false;
                }
                break;

            case R.id.selectSun:
                if (checked){
                    sun = true;
                }else{
                    sun = false;
                }
                break;
        }
    }
}


