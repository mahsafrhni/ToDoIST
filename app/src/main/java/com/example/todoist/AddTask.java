package com.example.todoist;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddTask extends AppCompatActivity {
    public EditText title, date, time, priority, other;
    private final static int numberOfTasks = 1000;
    ArrayList<Tasks> tasks = new ArrayList<>();
    final Calendar myCalendar = Calendar.getInstance();
    View view;
    TextView textView;
    //    int currentHour;
//    int currentMinute;
//    String amPm;
//   currentHour = myCalendar.get(Calendar.HOUR_OF_DAY);
//    currentMinute = myCalendar.get(Calendar.MINUTE);
    TimePickerDialog timePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        view = findViewById(R.id.view);
        textView = findViewById(R.id.textView4);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        priority = findViewById(R.id.priority);
        other = findViewById(R.id.other);
        time = findViewById(R.id.time);
        String Title = title.getText().toString();
        String D = date.getText().toString();
        String Priority = priority.getText().toString();
        String Other = other.getText().toString();
        String Time = time.getText().toString();
//        Tasks t = new Tasks(Title, D, Priority, Other);
//        tasks.add(t);
        final DatePickerDialog.OnDateSetListener Date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
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


//    private class TaskServer extends AsyncTask<String, String, String> {
//        DataOutputStream dataOutputStrea(String... data) {
//            try {
//
//            }
//        }

}
