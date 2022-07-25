package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilfinished) {
                textView.setText("Left: " +millisUntilfinished / 1000 );
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_LONG);
                textView.setText("Finished!");
            }
        }.start();
    }
}