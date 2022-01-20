package com.example.myfirstapp.activities;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.myfirstapp.R;

import java.sql.Time;
import java.util.Calendar;

public class RelativeLayout extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        editText = findViewById(R.id.editTextDate2);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final int hour = calendar.get(Calendar.HOUR_OF_DAY);
                final int minute = calendar.get(Calendar.MINUTE);


                TimePickerDialog timePicker = new TimePickerDialog(RelativeLayout.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

                        String time = String.valueOf(hourOfDay)+ ":" +String.valueOf(minute) ;
                        editText.setText(time);
                    }
                },hour,minute,true);
                timePicker.show();
            }
        });
    }

}