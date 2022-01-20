package com.example.myfirstapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.R;

public class Widgets extends AppCompatActivity {
    TextView textView;
    CheckBox checkBox,checkBox1,checkBox2;
    Button btn;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Spinner spinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        onButtonClick();
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.country_array));//setting the country_array to spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }

    private void onButtonClick() {
        textView = findViewById(R.id.text);
        checkBox = findViewById(R.id.checkBox);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        btn = findViewById(R.id.button);
        StringBuilder result = new StringBuilder();
        radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalAmount=0;

                result.append("Selected Items");
                if(checkBox.isChecked()){
                    result.append("\n Pizza");
                    totalAmount += 1000;
                }
                if(checkBox1.isChecked()){
                    result.append("\n Burger");
                    totalAmount += 580;
                }
                if(checkBox2.isChecked()){
                    result.append("\n Pasta");
                    totalAmount += 400;
                }


                result.append("\n Total Amount will be"+totalAmount+"Rs\n");
                textView.setText(result);

            }
        });

    }



}