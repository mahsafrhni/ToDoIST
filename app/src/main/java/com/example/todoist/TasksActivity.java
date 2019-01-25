package com.example.todoist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    ListView mList;
    ArrayList<Tasks> Tasks;
    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        mList = findViewById(R.id.list_view);
        Tasks = new ArrayList<>();
        TasksAdapter mAdapter = new TasksAdapter(this, Tasks);
        //add kardan
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//kari k hengame click rooye radif ha anjam mishavad
            }
        });
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TasksActivity.this, "FAB Clicked", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

