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
import com.example.ungdungtaptheduc.ui.home.HitDat;
import com.example.ungdungtaptheduc.ui.home.HomeFragment;
import com.example.ungdungtaptheduc.ui.home.HomeViewModel;

public class DetailHitDat2 extends AppCompatActivity {

    Button btnStart, btnNext;
    TextView timer;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hit_dat2);

        timer = findViewById(R.id.TimerHitDat);
        btnStart = findViewById(R.id.btnStartHitDat);
        btnNext = findViewById(R.id.btnNextHitDat);
        btnNext.setVisibility(View.INVISIBLE);


        boolean isRunning = false;


        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnStart.setText("RESTART");
                timer.setText(millisUntilFinished / 1000 + " giây");
            }

            @Override
            public void onFinish() {
                btnStart.setText("Quay về trang chính?");
                timer.setText("Finish!!!");
                Toast.makeText(DetailHitDat2.this, "Bài kế tiếp!", Toast.LENGTH_SHORT).show();
                btnNext.setVisibility(View.VISIBLE);

                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(DetailHitDat2.this, HitDat.class));
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
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailHitDat2.this,DetailHitDat3.class));
            }
        });
        Button btnSkip;

        btnSkip = findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailHitDat2.this, DetailHitDat3.class));
            }
        });

    }
}