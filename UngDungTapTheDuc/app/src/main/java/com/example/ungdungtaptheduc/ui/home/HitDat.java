package com.example.ungdungtaptheduc.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.ungdungtaptheduc.MainActivity;
import com.example.ungdungtaptheduc.NgayTapHitDatActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailHitDat3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.ungdungtaptheduc.R;

public class HitDat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hit_dat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "XungTheTeacher@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(),
                        "data" + bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }

        ImageButton btnStart;
        btnStart = findViewById(R.id.btnStart1);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HitDat.this, NgayTapHitDatActivity.class));
            }
        });

        ImageButton btnBack;
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clear_activity = new Intent(HitDat.this, MainActivity.class);
                clear_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(clear_activity);
                //startActivity(new Intent(HitDat.this,HomeFragment.class));
            }
        });


        VideoView videoView = findViewById(R.id.video_hitdat);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.howtopushup;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}