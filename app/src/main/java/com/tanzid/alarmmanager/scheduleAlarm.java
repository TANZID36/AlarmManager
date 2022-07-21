package com.tanzid.alarmmanager;

import static java.util.Calendar.PM;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.tanzid.alarmmanager.databinding.ActivityMainBinding;

//some of the methods doesn't work properly

public class scheduleAlarm extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MaterialTimePicker picker;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_alarm);

        createNotificationChannel();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*
        binding.selectedTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showTimePicker();
            }
        });

        binding.scheduleAlarmNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setAlarm();
            }
        });

         */


        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        findViewById(R.id.scheduleAlarmNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    private void createNotificationChannel() {
        CharSequence name = "Tanzid";
        String description = "Channel for Alarm Manager";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("Tanzid",name,importance);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel.setDescription(description);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
        }

    }

    /*private void setAlarm(){
        alarmManager = getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(this,AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calender.getTimInMillis());
                AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this,"Alarm has been set at", Toast.LENGTH_SHORT).show();

    }

     */

    /*private void showTimePicker() {

        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        picker.show(getSupportFragmentManager(),"Tanzid");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(picker.getHour()>12){
                    binding.selectedTime.setText(String.format("%02d",(picker.getHour()-12)+" : "+String.format("%02d",picker.getMinuate()) + " PM"));
                }
                else{
                    binding.selectedTime.setText(picker.getHour()+" : "+picker.getMinute()+" AM");
                }

                calender = Calender.getInstance();
                calender.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calender.set(Calender.MINUTE,picker.getMinute());
                calender.set(Calender.SECOND,0);
                calender.set(Calender.MILLISECOND,0);
            }
        });

    }

     */

}