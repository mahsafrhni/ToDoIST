package com.example.todoist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    //  ArrayList<Tasks> myTasks = new ArrayList<Tasks>();
    // RestaurantAdapter adapter = null;
    RecyclerView myRecycler;
    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        myRecycler = findViewById(R.id.recycler_view);
        // ListView tasks = (ListView) findViewById(R.id.list_view);
        //  adapter = new RestaurantAdapter();

        //  myTasks.setAdapter(adapter);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TasksActivity.this, AddTask.class));
            }
        });


    }
}

