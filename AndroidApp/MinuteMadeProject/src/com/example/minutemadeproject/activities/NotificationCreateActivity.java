package com.example.minutemadeproject.activities;

import java.util.ArrayList;
import java.util.Calendar;

import com.example.minutemadeproject.R;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
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
    String name, time;
    ArrayList<String> dates = new ArrayList<String>();
    Boolean mon = false,tues = false,wed = false,thurs = false,fri = false,sat = false,sun = false;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_notification);

        final EditText editName = (EditText) findViewById(R.id.editName);
        clock = (TextView) findViewById(R.id.clock);
        Button saveNote = (Button) findViewById(R.id.saveButton);

        final AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        final Calendar c = Calendar.getInstance();
        Intent intent = new Intent(this, Notify.class);
        final PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);

        saveNote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (time == null){
                    time = buildDate(12, 0);
                }
                name = editName.getText().toString();
                findDate();
                c.set(Calendar.HOUR_OF_DAY, hour);
                c.set(Calendar.MINUTE, minute);
                c.set(Calendar.DAY_OF_WEEK, 6);
                long when = c.getTimeInMillis();

                alarmManager.set(AlarmManager.RTC, when, pendingIntent);

                Toast toasty = Toast.makeText(getApplicationContext(), "Notification created for," +
                        dates + " at " + time, Toast.LENGTH_LONG);
                toasty.show();
                finish();
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
                        time = buildDate(hour, minute);
                        clock.setText(time);
                    }
                }, hour, minute, false);
                tPD.setTitle("Select Time");
                tPD.show();
            }
        });

    }

    public String buildDate(int hour, int minute){
        String temp = "";
        if (hour > 12){
            if (hour - 12 < 10) {
                temp += "0" + hour;
            }else{
                temp += hour;
            }
            temp += ":";

            if (minute < 10){
                temp += "0" + minute +  " PM";
            }else{
                temp += minute +  " PM";
            }

        }else{
            String h = String.valueOf(hour);
            if (hour - 12 < 10 && hour != 12) {
                temp += "0" + h;
            }else{
                temp += h;
            }
            temp += ":";
            if (minute < 10){
                temp += "0" + minute +  " AM";
            }else{
                temp += minute +  " AM";
            }
        }
        return temp;
    }
    public void findDate(){
        if (mon){
            dates.add("Monday");
        }
        if(tues){
            dates.add("Tuesday");
        }
        if(wed){
            dates.add("Wednesday");
        }
        if(thurs){
            dates.add("Thursday");
        }
        if(fri){
            dates.add("Friday");
        }
        if(sat){
            dates.add("Saturday");
        }
        if(sun){
            dates.add("Sunday");
        }
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


