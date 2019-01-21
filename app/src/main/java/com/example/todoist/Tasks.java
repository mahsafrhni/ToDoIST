package com.example.todoist;

public class Tasks {
    String title;
    String date_and_time;
    String priority;
    String other;

    public Tasks(String t, String d, String p, String o) {
        title = t;
        date_and_time = d;
        priority = p;
        other = o;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }
}
