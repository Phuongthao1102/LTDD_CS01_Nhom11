package com.example.ungdungtaptheduc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.GapBungAdapter;
import com.example.ungdungtaptheduc.Model.GapBung;

import java.util.ArrayList;

public class NgayTapGapBungActivity extends AppCompatActivity {
    private ArrayList<GapBung> mGapBung;
    private RecyclerView mRecyclerGapBung;
    private GapBungAdapter mGapBungAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngay_tap);
        mRecyclerGapBung = findViewById(R.id.recyclerHitDat);
        mGapBung = new ArrayList<>();
        createHeroList();
        mGapBungAdapter = new GapBungAdapter(this,mGapBung);
        mRecyclerGapBung.setAdapter(mGapBungAdapter);
        mRecyclerGapBung.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createHeroList() {
        mGapBung.add(new GapBung("Ngày 1"));
        mGapBung.add(new GapBung("Ngày 2"));
        mGapBung.add(new GapBung("Ngày 3"));
        mGapBung.add(new GapBung("Ngày 4: nghỉ ngơi"));
        mGapBung.add(new GapBung("Ngày 5"));
        mGapBung.add(new GapBung("Ngày 6"));
        mGapBung.add(new GapBung("Ngày 7"));
        mGapBung.add(new GapBung("Ngày 8: nghỉ ngơi"));
        mGapBung.add(new GapBung("Ngày 9"));
        mGapBung.add(new GapBung("Ngày 10"));
        mGapBung.add(new GapBung("Ngày 11"));
        mGapBung.add(new GapBung("Ngày 12"));

    }
}
