package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.List;

public class SelectedUserActivity extends AppCompatActivity {
    Intent intent;
    TextView tvSelectedDate;
    EditText etSelectedDate;
    TextView TimeTextView;
    Button PickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_user);
        intent= getIntent();
        tvSelectedDate = findViewById(R.id.tvSelectDate);
        etSelectedDate= findViewById(R.id.etSelectedDate);

        TimeTextView = findViewById(R.id.timetextview);
        PickTime= findViewById(R.id.picktime);

        final Calendar calender =  Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month =  calender.get(Calendar.MONTH);
        final int day =  calender.get(Calendar.DATE);


        etSelectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(SelectedUserActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month= month+1;

                        String date= day+"/"+month+"/"+year;
                        etSelectedDate.setText(date);
                    }
                },year,month,day);
                dialog.show();
            }
        });

        PickTime.setOnClickListener(new View.OnClickListener() {
            private int TIME_PICKER_INTERVAL = 15;
            NumberPicker minutePicker;
            List<String> displayedValues;
            @Override
            public void onClick(View v) {
                Calendar calendar  = Calendar.getInstance();
                int hours= calendar.get(Calendar.HOUR_OF_DAY);
                int mins =calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog= new TimePickerDialog(SelectedUserActivity.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       /* Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format =new SimpleDateFormat("k mm a");
                        String time= format.format(c.getTime());*/
                        TimeTextView.setText(hourOfDay+":"+minute);


                    }
                },hours,mins,true);
                timePickerDialog.show();

            }
        });




    }
    }
