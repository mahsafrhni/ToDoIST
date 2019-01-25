package com.example.todoist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {
    ListView mList;
    ArrayList<Tasks> myTasks;
    FloatingActionButton add;
    String nTitle=null, nDate=null, nPriority=null, nTime=null, nOther=null;
    // SparseBooleanArray sparseBooleanArray;
    Button change, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        mList = findViewById(R.id.list_view);
        change = findViewById(R.id.change);
        logout = findViewById(R.id.logout);
        myTasks = new ArrayList<>();
        TasksAdapter mAdapter = new TasksAdapter(this, myTasks);
        //gereftane maghadir az AddTaskActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("Title")) {
                nTitle = extras.getString("Title");
            }
            if (extras.containsKey("Date")) {
                nDate = extras.getString("Date");
            }
            if (extras.containsKey("Priority")) {
                nPriority = extras.getString("Priority");
            }
//            if (extras.containsKey("Time")) {
//                nTime = extras.getString("Time");
//            }
            if (extras.containsKey("Other")) {
                nOther = extras.getString("Other");
            }
        }
//add kardan
        myTasks.add(new Tasks(nTitle, nDate, nPriority, nOther));
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//kari k hengame click rooye radif ha anjam mishavad
//                sparseBooleanArray = mList.getCheckedItemPositions();
//                String ValueHolder = "";
//                i = 0;
//                while (i < sparseBooleanArray.size()) {
//                    if (sparseBooleanArray.valueAt(i)) {
//                        ValueHolder += myTasks.get(sparseBooleanArray.keyAt(i)) + ",";
//                    }
//                    i++;
//                }
//                ValueHolder = ValueHolder.replaceAll("(,)*$", "");
//                Toast.makeText(TasksActivity.this, "This tasks are done: " + ValueHolder, Toast.LENGTH_LONG).show();
            }
        });
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            //            @Override
//            public void onClick(View view) {
//                Toast.makeText(TasksActivity.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
//
//            }
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TasksActivity.this, AddTask.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {

                startActivity(new Intent(TasksActivity.this, StartActivity.class));

            }

        });
        change.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {

                startActivity(new Intent(TasksActivity.this, ChangeActivity.class));


            }

        });
    }
}
