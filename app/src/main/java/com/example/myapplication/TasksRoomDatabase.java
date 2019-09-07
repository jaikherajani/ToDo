package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class TasksRoomDatabase extends RoomDatabase {

    private static volatile TasksRoomDatabase INSTANCE;

    static TasksRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TasksRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TasksRoomDatabase.class, "task_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract TaskDAO taskdao();
}
