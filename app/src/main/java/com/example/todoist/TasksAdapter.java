package com.example.todoist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TasksAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Tasks> tasks;

    public TasksAdapter(Context mContext, ArrayList<Tasks> tasks) {
        this.mContext = mContext;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txtTitle, txtDate, txtPriority;

        public ViewHolder(View mView) {
            txtTitle = mView.findViewById(R.id.txt_title);
            txtDate = mView.findViewById(R.id.txt_date);
            txtPriority = mView.findViewById(R.id.txt_priority);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vHolder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);
            vHolder = new ViewHolder(view);
            view.setTag(vHolder);
        } else {
            //agar ja nadasht negahdari mishavand ta scroll shavad
            vHolder = (ViewHolder) view.getTag();
        }

        Tasks task = (Tasks) getItem(i);

        vHolder.txtTitle.setText(task.getTitle());
        vHolder.txtDate.setText(task.getDate().toString());
        vHolder.txtPriority.setText(task.getPriority());
        return view;

    }
}

