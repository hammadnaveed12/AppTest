package com.example.myfirstapp.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConstraintLayout extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

       /* vd = findViewById(R.id.video_view);
        button = findViewById(R.id.buttonOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConstraintLayout.this, "Redirecting...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), RelativeLayout.class);
                startActivity(i);
            }
        });*/
        editText = findViewById(R.id.editTextDate2);
        textView = findViewById(R.id.textid);
        editText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ConstraintLayout.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear+1)
                                + "/" + String.valueOf(year);
                        editText.setText(date);
                        textView.setText(String.valueOf(milliseconds(date)));

                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });
    }
    public long milliseconds(String date)
    {
        //String date_ = date;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            Date mDate = sdf.parse(date);
            long timeInMilliseconds = mDate.getTime();
            System.out.println("Date in milli :: " + timeInMilliseconds);
            return timeInMilliseconds;
        }
        catch (ParseException e)
        {

            e.printStackTrace();
        }

        return 0;
    }

    public void onButtonClick(View view) {
//        String path = "android.assets://" + getPackageName() + "/" + "/raw/video";
//        vd.setVideoURI(Uri.parse(path));
//        vd.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(vd);
//        vd.setMediaController(mediaController);
//        vd.start();

        ViewGroup viewgroup = findViewById(R.id.content);
        View dialog = LayoutInflater.from(this).inflate(R.layout.custom_layout, viewgroup, false);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//                alert.setIcon(android.R.mipmap.sym_def_app_icon);
//                alert.setTitle("Are you sure to exit");
//                alert.setMessage("Press Yes to Exit");
        alert.setView(dialog);
//                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        finish();
//                    }
//                });
//                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getApplicationContext(),"Not exited",Toast.LENGTH_SHORT).show();
//                    }
//                });
        Button btn = dialog.findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConstraintLayout.this, "Redirecting...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), RelativeLayout.class);
                startActivity(i);
            }
        });

        alert.create();
        alert.show();
    }
}