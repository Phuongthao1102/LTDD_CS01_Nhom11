package com.example.ungdungtaptheduc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdungtaptheduc.Adapter.NangTaAdapter;
import com.example.ungdungtaptheduc.Adapter.NhayDayAdapter;
import com.example.ungdungtaptheduc.Model.NangTa;
import com.example.ungdungtaptheduc.Model.NhayDay;

import java.util.ArrayList;

public class NgayNangTaActivity extends AppCompatActivity {
    private ArrayList<NangTa> mNangTa;
    private RecyclerView mRecyclerHitDat;
    private NangTaAdapter mNangTaAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngay_tap);
        mRecyclerHitDat = findViewById(R.id.recyclerHitDat);
        mNangTa = new ArrayList<>();
        createHeroList();
        mNangTaAdapter = new NangTaAdapter(this,mNangTa);
        mRecyclerHitDat.setAdapter(mNangTaAdapter);
        mRecyclerHitDat.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createHeroList() {
        mNangTa.add(new NangTa("Ngày 1"));
        mNangTa.add(new NangTa("Ngày 2"));
        mNangTa.add(new NangTa("Ngày 3"));
        mNangTa.add(new NangTa("Ngày 4: nghỉ ngơi"));
        mNangTa.add(new NangTa("Ngày 5"));
        mNangTa.add(new NangTa("Ngày 6"));
        mNangTa.add(new NangTa("Ngày 7"));
        mNangTa.add(new NangTa("Ngày 8: nghỉ ngơi"));
        mNangTa.add(new NangTa("Ngày 9"));
        mNangTa.add(new NangTa("Ngày 10"));
        mNangTa.add(new NangTa("Ngày 11"));
        mNangTa.add(new NangTa("Ngày 12"));

    }
}
