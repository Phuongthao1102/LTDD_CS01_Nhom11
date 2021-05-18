package com.example.ungdungtaptheduc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.HitDatAdapter;
import com.example.ungdungtaptheduc.Model.HitDat;

import java.util.ArrayList;

public class NgayTapHitDatActivity extends AppCompatActivity {
    private ArrayList<HitDat> mHitDat;
    private RecyclerView mRecyclerHitDat;
    private HitDatAdapter mHitDatAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngay_tap);
        mRecyclerHitDat = findViewById(R.id.recyclerHitDat);
        mHitDat = new ArrayList<>();
        createHeroList();
        mHitDatAdapter = new HitDatAdapter(this,mHitDat);
        mRecyclerHitDat.setAdapter(mHitDatAdapter);
        mRecyclerHitDat.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createHeroList() {
        mHitDat.add(new HitDat("Ngày 1"));
        mHitDat.add(new HitDat("Ngày 2"));
        mHitDat.add(new HitDat("Ngày 3"));
        mHitDat.add(new HitDat("Ngày 4: nghỉ ngơi"));
        mHitDat.add(new HitDat("Ngày 5"));
        mHitDat.add(new HitDat("Ngày 6"));
        mHitDat.add(new HitDat("Ngày 7"));
        mHitDat.add(new HitDat("Ngày 8: nghỉ ngơi"));
        mHitDat.add(new HitDat("Ngày 9"));
        mHitDat.add(new HitDat("Ngày 10"));
        mHitDat.add(new HitDat("Ngày 11"));
        mHitDat.add(new HitDat("Ngày 12"));
        mHitDat.add(new HitDat("Ngày 13"));
        mHitDat.add(new HitDat("Ngày 14: nghỉ ngơi"));
        mHitDat.add(new HitDat("Ngày 15"));
        mHitDat.add(new HitDat("Ngày 16"));
        mHitDat.add(new HitDat("Ngày 17"));
        mHitDat.add(new HitDat("Ngày 18"));
        mHitDat.add(new HitDat("Ngày 19"));
        mHitDat.add(new HitDat("Ngày 20"));
        mHitDat.add(new HitDat("Ngày 21"));
        mHitDat.add(new HitDat("Ngày 22"));
        mHitDat.add(new HitDat("Ngày 22"));
        mHitDat.add(new HitDat("Ngày 23"));
        mHitDat.add(new HitDat("Ngày 24"));
        mHitDat.add(new HitDat("Ngày 25"));
        mHitDat.add(new HitDat("Ngày 26"));
        mHitDat.add(new HitDat("Ngày 27"));
        mHitDat.add(new HitDat("Ngày 28"));
        mHitDat.add(new HitDat("Ngày 29"));
        mHitDat.add(new HitDat("Ngày 30"));

    }
}
