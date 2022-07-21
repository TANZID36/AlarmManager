package com.tanzid.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class setAlarm extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        //creating object for alarmmanager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //creating object for vibrator
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        //will set alarm upon clicking Set Alarm button
        findViewById(R.id.setAlarmNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //extracts current time from the system
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

                //makes toast
                Toast.makeText(setAlarm.this, "Alarm started at "+currentTime, Toast.LENGTH_SHORT).show();

                //parse the string input to integer
                int time = Integer.parseInt(((EditText)findViewById(R.id.secondInput)).getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*1000);

                //jumps to MyReceiver class to trigger the broadcast
                Intent iBroadCast = new Intent(setAlarm.this, MyReceiver.class);
                PendingIntent pi = PendingIntent.getBroadcast(setAlarm.this,ALARM_REQ_CODE,iBroadCast, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime, pi);

                //vibration patter
                long[] pattern = {0,500,10,500};
                vibrator.vibrate(pattern, -1);
            }
        });
    }
}