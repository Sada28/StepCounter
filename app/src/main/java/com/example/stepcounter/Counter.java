package com.example.stepcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Counter extends AppCompatActivity implements SensorEventListener {
    TextView tv_steps;
    Button btn1;
    SensorManager sensorManager;
    Sensor sensor;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        tv_steps = (TextView) findViewById ( R.id.tv_steps );
        btn1=findViewById(R.id.btn1);

        sensorManager = (SensorManager) getSystemService ( Context.SENSOR_SERVICE);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_steps.setText(" ");
            }
        });

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (running){
            tv_steps.setText ( String.valueOf ( sensorEvent.values[0] ) );
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume() {
        super.onResume ();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor ( sensor.TYPE_STEP_COUNTER );
        if(countSensor!= null){
            sensorManager.registerListener ( this,countSensor,SensorManager.SENSOR_DELAY_UI );
        }else {
            Toast.makeText ( this,"SENSOR NOT FOUND",Toast.LENGTH_SHORT ).show ();
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}

