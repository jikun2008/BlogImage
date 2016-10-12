package com.example.administrator.activitylifesingletask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, TAG + "onCreate");
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        Log.i(TAG, TAG + "onStart");
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.i(TAG, TAG + "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, TAG + "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, TAG + "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, TAG + "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {

        Log.i(TAG, TAG + "onRestart");
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.i(TAG, TAG + "onNewIntent");
        super.onNewIntent(intent);
    }

    public void toOtherActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SingleTaskActivity.class);
        startActivity(intent);

    }
}
