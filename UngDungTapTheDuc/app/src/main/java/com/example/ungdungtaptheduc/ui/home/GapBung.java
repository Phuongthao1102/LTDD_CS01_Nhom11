package com.example.ungdungtaptheduc.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.ungdungtaptheduc.MainActivity;
import com.example.ungdungtaptheduc.NgayTapGapBungActivity;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailGapBung;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.ungdungtaptheduc.R;

public class GapBung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gap_bung);
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

        ImageButton btnStartGapBung;
        btnStartGapBung = findViewById(R.id.btnStartGapBung);
        btnStartGapBung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GapBung.this, NgayTapGapBungActivity.class));
            }
        });

        ImageButton btnBack;
        btnBack = findViewById(R.id.btnBackGapBung);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clear_activity = new Intent(GapBung.this, MainActivity.class);
                clear_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(clear_activity);
                //startActivity(new Intent(GapBung.this,HomeFragment.class));
            }
        });

        VideoView videoView = findViewById(R.id.video_gapbung);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.how;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}