package com.example.administrator.activitylifesingletask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
    }

    public void toOtherActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);

    }
}
