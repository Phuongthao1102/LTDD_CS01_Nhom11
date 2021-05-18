package com.example.ungdungtaptheduc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.PlankAdapter;
import com.example.ungdungtaptheduc.Adapter.SquatAdapter;
import com.example.ungdungtaptheduc.Model.Plank;
import com.example.ungdungtaptheduc.Model.Squat;

import java.util.ArrayList;

public class NgayTapPlankActivity extends AppCompatActivity {
    private ArrayList<Plank> mPlank;
    private RecyclerView mRecyclerHitDat;
    private PlankAdapter mPlankAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngay_tap);
        mRecyclerHitDat = findViewById(R.id.recyclerHitDat);
        mPlank = new ArrayList<>();
        createHeroList();
        mPlankAdapter = new PlankAdapter(this,mPlank);
        mRecyclerHitDat.setAdapter(mPlankAdapter);
        mRecyclerHitDat.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createHeroList() {
        mPlank.add(new Plank("Ngày 1"));
        mPlank.add(new Plank("Ngày 2"));
        mPlank.add(new Plank("Ngày 3"));
        mPlank.add(new Plank("Ngày 4: nghỉ ngơi"));
        mPlank.add(new Plank("Ngày 5"));
        mPlank.add(new Plank("Ngày 6"));
        mPlank.add(new Plank("Ngày 7"));
        mPlank.add(new Plank("Ngày 8: nghỉ ngơi"));
        mPlank.add(new Plank("Ngày 9"));
        mPlank.add(new Plank("Ngày 10"));
        mPlank.add(new Plank("Ngày 11"));
        mPlank.add(new Plank("Ngày 12"));

    }
}
