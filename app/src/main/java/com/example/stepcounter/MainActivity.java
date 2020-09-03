package com.example.stepcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.img);
        Timer tm1=new Timer();
        tm1.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i =new Intent(MainActivity.this,Counter.class);
                startActivity(i);
                finish();
            }
        },9000);

    }
}