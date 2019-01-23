package com.example.todoist;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddTask extends AppCompatActivity {
    public EditText title, date, time, priority, other;
    private final static int numberOfTasks = 1000;
    ArrayList<String> tasks = (ArrayList<String>) getIntent().getSerializableExtra("tasks");
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        priority = findViewById(R.id.priority);
        other = findViewById(R.id.other);
        time = findViewById(R.id.time);
        String Title = title.getText().toString();
        //String date = date.getText().toString();
        String Priority = priority.getText().toString();
        String Other = other.getText().toString();
        Tasks task = new Tasks(Title, date, Priority, Other);
        // tasks.add(task);
        final DatePickerDialog.OnDateSetListener Date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddTask.this, Date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddTask.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                                //time.setText(hourOfDay + ":" + minutes);
                            }
                        }, 0, 0, false);
                timePickerDialog.show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        date.setText(sdf.format(myCalendar.getTime()));
    }
}
