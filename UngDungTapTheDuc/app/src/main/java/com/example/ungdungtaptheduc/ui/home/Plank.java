package com.example.ungdungtaptheduc.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.ungdungtaptheduc.MainActivity;
import com.example.ungdungtaptheduc.NgayTapPlankActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailPlank;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailSquat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.ungdungtaptheduc.R;

public class Plank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plank);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ImageButton btnStartPlank;
        btnStartPlank = findViewById(R.id.btnStartPlank);
        btnStartPlank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Plank.this, NgayTapPlankActivity.class));
            }
        });
        ImageButton btnBack;
        btnBack = findViewById(R.id.btnBackPlank);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clear_activity = new Intent(Plank.this, MainActivity.class);
                clear_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(clear_activity);
                //startActivity(new Intent(Plank.this,HomeFragment.class));
            }
        });
        VideoView videoView = findViewById(R.id.video_plank);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.howtoplank;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }
}