package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.database.annotations.NotNull;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    private long task_id;

    @NotNull
    @ColumnInfo(name = "task_name")
    private String task;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "notify")
    private String notify;

    @ColumnInfo(name = "priority")
    private int priority;

    @Ignore
    public Task(String task, String date, String time, String notify, int priority) {
        this.task = task;
        this.date = date;
        this.time = time;
        this.notify = notify;
        this.priority = priority;
    }

    public Task(long task_id, String task, String date, String time, String notify, int priority) {
        this.task_id = task_id;
        this.task = task;
        this.date = date;
        this.time = time;
        this.notify = notify;
        this.priority = priority;
    }

    public String getTask() {
        System.out.println("Task : getTask()" + task);
        return task;
    }

    public void setTask(String task) {
        this.task = task;
        System.out.println("Task : setTask() " + task);
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
