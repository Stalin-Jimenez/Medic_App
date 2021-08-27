package com.example.medic_app.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.medic_app.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    int contador =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prog();
        TimerTask tarea=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo=new Timer();
        tiempo.schedule(tarea,3000);

    }

    private void prog() {
        pb=(ProgressBar)findViewById(R.id.pb);
        final Timer tiempo=new Timer();
        TimerTask tiempo2=new TimerTask() {
            @Override
            public void run() {
                contador++;
                pb.setProgress(contador);
                if(contador == 100){
                    tiempo.cancel();
                }
            }
        };
        tiempo.schedule(tiempo2,0,30);
    }
}