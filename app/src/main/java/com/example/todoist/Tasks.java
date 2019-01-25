package com.example.todoist;

import java.sql.Time;

public class Tasks {
    String title;
    String date;
    Time time;
    String priority;
    String other;
    int value; /* 0 : checkbox disable, 1 : checkbox enable */

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String toStringDate(Date d) {
//       return d.toString();
//
//    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Tasks(String t, String d, String p, String o) {
        //super();
        title = t;
        date = d;
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


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

//    public static Comparator<Tasks> getTaskDateComperator() {
//        return taskDateComperator;
//    }

    public String date() {
        return date;
    }

    public String getPriority() {
        return priority;
    }

    public String getOther() {
        return other;
    }


    //    public int compareTo(Tasks compareTask) {
//return getDate().compareTo(compareTask.getDate());
////        EditText compareQuantity = ((Tasks) compareTask).date();
//        //ascending order
//      //  return this.Tasks - compareQuantity;
//
//        //descending order
//        //return compareQuantity - this.quantity;
//
//    }
//    Collections.sort(myList, new Comparator<MyObject>() {
//        public int compare(MyObject o1, MyObject o2) {
//            return o1.getDateTime().compareTo(o2.getDateTime());
//        }
//    });
//
//    public static Comparator<Tasks> taskDateComperator=new Comparator<Tasks>() {
//        @Override
//        public int compare(Tasks o1, Tasks o2) {
//            String date1=o1.getDate().
//
//        }
//    }
//}
//
    public String compare(Tasks t1, Tasks t2) {
        String sooner = null;
//    String compareQuantity = ((Tasks) t1).getDate();
        if (t1.getDate().compareTo(t2.getDate()) > 0) {
//date2 is sooner
            sooner = t2.getDate();
        }
        if (t1.getDate().compareTo(t2.getDate()) < 0) {
//date1 is later
            sooner = t1.getDate();
        }
        if (t1.getDate().compareTo(t2.getDate()) == 0) {
//same time
            sooner = t1.getDate();

        }
        //ascending order
        //return this.date - compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;
        return sooner;

    }
}
