package com.example.ungdungtaptheduc;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.HitDatAdapter;
import com.example.ungdungtaptheduc.Adapter.SquatAdapter;
import com.example.ungdungtaptheduc.Model.HitDat;
import com.example.ungdungtaptheduc.Model.Squat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.HitDatAdapter;
import com.example.ungdungtaptheduc.Model.HitDat;

import java.util.ArrayList;

public class NgayTapSquatActivity extends AppCompatActivity{
        private ArrayList<Squat> mSquat;
        private RecyclerView mRecyclerHitDat;
        private SquatAdapter mSquatAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngay_tap);
        mRecyclerHitDat = findViewById(R.id.recyclerHitDat);
        mSquat = new ArrayList<>();
        createHeroList();
        mSquatAdapter = new SquatAdapter(this,mSquat);
        mRecyclerHitDat.setAdapter(mSquatAdapter);
        mRecyclerHitDat.setLayoutManager(new LinearLayoutManager(this));

    }

        private void createHeroList() {
            mSquat.add(new Squat("Ngày 1"));
            mSquat.add(new Squat("Ngày 2"));
            mSquat.add(new Squat("Ngày 3"));
            mSquat.add(new Squat("Ngày 4: nghỉ ngơi"));
            mSquat.add(new Squat("Ngày 5"));
            mSquat.add(new Squat("Ngày 6"));
            mSquat.add(new Squat("Ngày 7"));
            mSquat.add(new Squat("Ngày 8: nghỉ ngơi"));
            mSquat.add(new Squat("Ngày 9"));
            mSquat.add(new Squat("Ngày 10"));
            mSquat.add(new Squat("Ngày 11"));
            mSquat.add(new Squat("Ngày 12"));

        }
}
