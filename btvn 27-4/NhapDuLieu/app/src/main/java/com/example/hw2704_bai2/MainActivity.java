package com.example.hw2704_bai2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnBirthDate, btnSubmit;
    CalendarView calendar;
    CheckBox confirmCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setVisibility(View.GONE);
        btnBirthDate = (Button) findViewById(R.id.btnBirthDate);
        btnBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (calendar.getVisibility() == View.VISIBLE) {
                    calendar.setVisibility(View.GONE);
                } else {
                    calendar.setVisibility(View.VISIBLE);
                }
            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                btnBirthDate.setText("Date: " + dayOfMonth + " " + month + " " + year);
            }
        });
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        confirmCheckBox = (CheckBox) findViewById(R.id.confirmCheckBox);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Toast message = new Toast(getApplicationContext());
                    if (!confirmCheckBox.isChecked()) {
                        confirmCheckBox.setBackgroundColor(Color.RED);
                        message.setText("H??y x??c nh???n g???i!");
                    } else {
                        confirmCheckBox.setBackgroundColor(0);
                        message.setText("Nh???p th??ng tin th??nh c??ng");
                    }
                    message.show();
                } else {
                    Toast message = new Toast(getApplicationContext());
                    message.setText("Nh???p th??ng tin kh??ng th??nh c??ng. \n H??y nh???p ?????");
                    message.show();
                }
            }
        });

    }
    public boolean isValid() {
        boolean flag = true;
        if (((EditText) findViewById(R.id.mssvTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.mssvTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.mssvTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.cccdTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.cccdTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.cccdTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.nameTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.nameTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.nameTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.phoneTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.phoneTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.phoneTextField)).setBackgroundColor(0);

        if (((EditText) findViewById(R.id.emailTextField)).getText().toString().trim().isEmpty()) {
            ((EditText) findViewById(R.id.emailTextField)).setBackgroundColor(Color.RED);
            flag = false;
        } else
            ((EditText) findViewById(R.id.emailTextField)).setBackgroundColor(0);

        return flag;
    }
}