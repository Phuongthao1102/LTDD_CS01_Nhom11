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

public class DetailGapBung2 extends AppCompatActivity {

    Button btnStart,btnSkip;
    TextView timer;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gap_bung2);

        timer = findViewById(R.id.TimerGapBung2);
        btnStart = findViewById(R.id.btnStartGapbung2);
        btnSkip = findViewById(R.id.btnSkipGapBung2);

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
                Toast.makeText(DetailGapBung2.this, "XONG!", Toast.LENGTH_SHORT).show();

                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent clear_activity = new Intent(DetailGapBung2.this, MainActivity.class);
                        clear_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(clear_activity);
                        //startActivity(new Intent(DetailGapBung2.this, GapBung.class));
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
                startActivity(new Intent(DetailGapBung2.this,GapBung.class));
            }
        });
    }
}