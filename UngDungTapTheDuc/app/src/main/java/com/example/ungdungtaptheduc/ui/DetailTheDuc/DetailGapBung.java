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
import com.example.ungdungtaptheduc.ui.home.GapBung;

public class DetailGapBung extends AppCompatActivity {

    Button btnStart,btnSkip,btnNext;
    TextView timer;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gap_bung);

        timer = findViewById(R.id.TimerGapBung);
        btnStart = findViewById(R.id.btnStartGapbung1);
        btnSkip = findViewById(R.id.btnSkipGapBung1);
        btnNext = findViewById(R.id.btnNextGapBung1);
        btnNext.setVisibility(View.INVISIBLE);

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
                Toast.makeText(DetailGapBung.this, "Bài kế tiếp!", Toast.LENGTH_SHORT).show();
                btnNext.setVisibility(View.VISIBLE);

                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DetailGapBung.this, GapBung.class));
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
                startActivity(new Intent(DetailGapBung.this,DetailGapBung2.class));
            }
        });
    }
}