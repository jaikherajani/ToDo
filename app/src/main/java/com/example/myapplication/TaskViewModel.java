package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TasksRepository mRepository;

    private LiveData<List<Task>> tasks;

    public TaskViewModel(Application application) {
        super(application);
        mRepository = new TasksRepository(application);
        tasks = mRepository.getAllTasks();
    }

    LiveData<List<Task>> getAllTasks() {
        return tasks;
    }

    public void insert(Task task) {
        mRepository.insert(task);
    }

}
