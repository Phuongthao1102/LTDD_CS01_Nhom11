package com.example.ungdungtaptheduc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.HitDatAdapter;
import com.example.ungdungtaptheduc.Adapter.NhayDayAdapter;
import com.example.ungdungtaptheduc.Model.HitDat;
import com.example.ungdungtaptheduc.Model.NhayDay;

import java.util.ArrayList;

public class NgayNhayDayActivity extends AppCompatActivity {
    private ArrayList<NhayDay> mNhayDay;
    private RecyclerView mRecyclerHitDat;
    private NhayDayAdapter mNhayDayAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngay_tap);
        mRecyclerHitDat = findViewById(R.id.recyclerHitDat);
        mNhayDay = new ArrayList<>();
        createHeroList();
        mNhayDayAdapter = new NhayDayAdapter(this,mNhayDay);
        mRecyclerHitDat.setAdapter(mNhayDayAdapter);
        mRecyclerHitDat.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createHeroList() {
        mNhayDay.add(new NhayDay("Ngày 1"));
        mNhayDay.add(new NhayDay("Ngày 2"));
        mNhayDay.add(new NhayDay("Ngày 3"));
        mNhayDay.add(new NhayDay("Ngày 4: nghỉ ngơi"));
        mNhayDay.add(new NhayDay("Ngày 5"));
        mNhayDay.add(new NhayDay("Ngày 6"));
        mNhayDay.add(new NhayDay("Ngày 7"));
        mNhayDay.add(new NhayDay("Ngày 8: nghỉ ngơi"));
        mNhayDay.add(new NhayDay("Ngày 9"));
        mNhayDay.add(new NhayDay("Ngày 10"));
        mNhayDay.add(new NhayDay("Ngày 11"));
        mNhayDay.add(new NhayDay("Ngày 12"));

    }
}

