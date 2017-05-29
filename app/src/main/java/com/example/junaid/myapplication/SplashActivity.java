package com.example.junaid.myapplication;

import java.lang.String;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load password
        SharedPreferences settings = getSharedPreferences("PREFS",0);
        Password = settings.getString("password","");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Password.equals(""))
                {
                    // if there is no password
                    Intent intent = new Intent(getApplicationContext(),CreatePasswordActivity.class);
                    startActivity(intent);
                    finish();

                } else
                {
                    //if there is password
                    Intent intent = new Intent(getApplicationContext(),EnterpasswordActivity.class);
                    startActivity(intent);
                    finish();

                }



            }
        },2000 );

    }
}
