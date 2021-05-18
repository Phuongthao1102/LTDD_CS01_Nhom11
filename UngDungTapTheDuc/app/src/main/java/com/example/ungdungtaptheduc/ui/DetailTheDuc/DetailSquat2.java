package com.example.ungdungtaptheduc.ui.DetailTheDuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.ui.home.Squat;

public class DetailSquat2 extends AppCompatActivity {

    Button btnStart,btnSkip;
    TextView timer;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_squat2);

        timer = findViewById(R.id.TimerSquat2);
        btnStart = findViewById(R.id.btnStartSquat2);
        btnSkip = findViewById(R.id.btnSkipSquat2);
        countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnStart.setText("RESTART");
                timer.setText(millisUntilFinished / 1000 + " giây");
            }

            @Override
            public void onFinish() {
                btnStart.setText("Quay về trang chính?");
                timer.setText("Finish!!!");
                Toast.makeText(DetailSquat2.this, "XONG!", Toast.LENGTH_SHORT).show();

                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DetailSquat2.this, Squat.class));
                    }
                });
            }
        };
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailSquat2.this,Squat.class));
            }
        });
    }
}