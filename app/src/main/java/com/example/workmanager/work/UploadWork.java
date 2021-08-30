package com.example.workmanager.work;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadWork extends Worker {

    public UploadWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String data = getInputData().getString("username");
        Log.d("data", "doWork: "+data);
        uploadUserName(data);
        return Result.success();
    }

    private void uploadUserName(String username) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/user1/username");
        myRef.setValue(username);
    }
}
