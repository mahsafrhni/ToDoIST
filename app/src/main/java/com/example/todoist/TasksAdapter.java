package com.example.todoist;

import android.renderscript.RenderScript;
import android.service.quicksettings.Tile;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.MyViewHolder> {

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView Title;
        public TextView Priority;
        public TextView Time;
        public TextView Other;


        public MyViewHolder(View TasksView) {
            super(TasksView);

            Title = TasksView.findViewById(R.id.atitle);
            Priority = TasksView.findViewById(R.id.apriority);
            Time = TasksView.findViewById(R.id.atime);
            Other = TasksView.findViewById(R.id.aother);
        }
    }

}
