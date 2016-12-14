package com.example.krupal.roughestimantion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splashscreen extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 3000;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(Splashscreen.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                },SPLASH_TIME_OUT);

    }


}
