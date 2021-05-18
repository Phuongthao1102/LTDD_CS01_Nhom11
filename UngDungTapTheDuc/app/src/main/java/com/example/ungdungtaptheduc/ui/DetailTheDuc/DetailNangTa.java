package com.example.ungdungtaptheduc.ui.DetailTheDuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ungdungtaptheduc.MainActivity;
import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.ui.home.GapBung;
import com.example.ungdungtaptheduc.ui.home.TapTa;

public class DetailNangTa extends AppCompatActivity {

    Button btnStart,btnSkip,btnNext;
    TextView timer;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nang_ta);

        timer = findViewById(R.id.TimerNangTa1);
        btnStart = findViewById(R.id.btnStartNangTa1);
        btnSkip = findViewById(R.id.btnSkipNangTa1);
        btnNext = findViewById(R.id.btnNextNangTa1);
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
                Toast.makeText(DetailNangTa.this, "Bài kế tiếp!", Toast.LENGTH_SHORT).show();
                btnNext.setVisibility(View.VISIBLE);

                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent clear_activity = new Intent(DetailNangTa.this, MainActivity.class);
                        clear_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(clear_activity);
                        //startActivity(new Intent(DetailNangTa.this, TapTa.class));
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
                startActivity(new Intent(DetailNangTa.this,TapTa.class));
            }
        });
    }
}