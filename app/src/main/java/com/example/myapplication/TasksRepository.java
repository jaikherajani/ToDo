package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TasksRepository {

    private TaskDAO mTaskDAO;
    private LiveData<List<Task>> mAllTasks;

    TasksRepository(Application application) {
        TasksRoomDatabase db = TasksRoomDatabase.getDatabase(application);
        mTaskDAO = db.taskdao();
        mAllTasks = mTaskDAO.getAllTasks();
    }

    LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }


    public void insert(Task Task) {
        new insertAsyncTask(mTaskDAO).execute(Task);
    }

    private static class insertAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDAO mAsyncTaskDao;

        insertAsyncTask(TaskDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Task... params) {
            mAsyncTaskDao.insert(params[0]);
            System.out.println("TasksRepository " + params[0].getTask());
            return null;
        }
    }
}
