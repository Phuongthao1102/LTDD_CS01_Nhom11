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
import com.example.ungdungtaptheduc.ui.home.HitDat;
import com.example.ungdungtaptheduc.ui.home.HomeFragment;
import com.example.ungdungtaptheduc.ui.home.HomeViewModel;

public class DetailHitDat3 extends AppCompatActivity {

    Button btnStart;
    TextView timer;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hit_dat3);

        timer = findViewById(R.id.TimerHitDat);
        btnStart = findViewById(R.id.btnStartHitDat);


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
                Toast.makeText(DetailHitDat3.this, "Bài kế tiếp!", Toast.LENGTH_SHORT).show();
                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent clear_activity = new Intent(DetailHitDat3.this, MainActivity.class);
                        clear_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(clear_activity);
                        //startActivity(new Intent(DetailHitDat3.this, HitDat.class));
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

        Button btnSkip;

        btnSkip = findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailHitDat3.this, HitDat.class));
            }
        });

    }
}