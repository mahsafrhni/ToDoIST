package com.example.todoist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TasksActivity extends AppCompatActivity {


    ListView tasks;
    String[] myTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        tasks = findViewById(R.id.list_view);

        myTasks = new String[]{"1", "2"};

        ArrayAdapter<String> mAdapter =
                new ArrayAdapter<String>(this, R.layout.list_item, R.id.list_view, myTasks);

        tasks.setAdapter(mAdapter);

    }
}
