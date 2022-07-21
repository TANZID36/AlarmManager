package com.tanzid.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button buttonUp; //button for set Alarm
    private Button buttonDown; //button for schedule Alarm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //will open openActivitySetAlarm upon button click
        buttonUp = (Button) findViewById(R.id.setAlarmButton);
        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySetAlarm();
            }
        });

        //will open openActivityScheduleAlarm upon button click
        buttonDown = (Button) findViewById(R.id.scheduleAlarmButton);
        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityScheduleAlarm();
            }
        });



    }

    //using intent to jump to next process which is setAlarm
    public void openActivitySetAlarm(){
        Intent intent = new Intent(this, setAlarm.class);
        startActivity(intent);
    }

    //using intent to jump to next process which is scheduleAlarm
    public void openActivityScheduleAlarm(){
        Intent intent = new Intent(this, scheduleAlarm.class);
        startActivity(intent);
    }


}