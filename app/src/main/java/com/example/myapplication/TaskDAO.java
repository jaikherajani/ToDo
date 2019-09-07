package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDAO {

    @Insert
    void insert(Task task);

    @Query("DELETE FROM tasks")
    void deleteAll();

    @Query("SELECT * from tasks ORDER BY task_id ASC")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * from tasks ORDER BY priority ASC")
    List<Task> getAllTasksByPriority();
}
