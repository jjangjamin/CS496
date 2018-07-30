package com.example.user.cs496.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.cs496.R;

public class HomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent mainIntent = new Intent(HomeActivity.this, LoadingActivity.class);
                startActivity(mainIntent);
                finish();


                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        },SPLASH_TIME_OUT);

    }
}