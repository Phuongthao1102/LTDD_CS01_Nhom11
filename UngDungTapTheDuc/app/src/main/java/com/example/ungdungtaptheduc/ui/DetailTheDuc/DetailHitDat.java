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
import com.example.ungdungtaptheduc.ui.home.HomeViewModel;

public class DetailHitDat extends AppCompatActivity {

    Button btnStart, btnNext,btnSkip;
    TextView timer;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_hit_dat);

            timer = findViewById(R.id.TimerHitDat);
            btnStart = findViewById(R.id.btnStartHitDat);
            btnNext = findViewById(R.id.btnNextHitDat);
            btnNext.setVisibility(View.INVISIBLE);


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
                    Toast.makeText(DetailHitDat.this, "Bài kế tiếp!", Toast.LENGTH_SHORT).show();
                    btnNext.setVisibility(View.VISIBLE);

                    btnStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(DetailHitDat.this, HitDat.class));
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
                    startActivity(new Intent(DetailHitDat.this, DetailHitDat2.class));
                }
            });

            btnSkip = findViewById(R.id.btnSkip);
            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DetailHitDat.this, DetailHitDat2.class));
                }
            });
    }
}