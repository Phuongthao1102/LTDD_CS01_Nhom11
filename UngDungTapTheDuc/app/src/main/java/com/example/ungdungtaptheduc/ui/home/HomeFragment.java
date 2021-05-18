package com.example.ungdungtaptheduc.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.ui.DetailTheDuc.DetailHitDat;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton buttonopenhitdat = (ImageButton) view.findViewById(R.id.btnHitDat);
        ImageButton buttongapbung = (ImageButton) view.findViewById(R.id.btnGapBung);
        ImageButton buttonsquat = view.findViewById(R.id.btnSquat);
        ImageButton buttonplank = view.findViewById(R.id.btnPlank);
        ImageButton buttonnhayday = view.findViewById(R.id.btnRopeJump);
        ImageButton buttonnagta = view.findViewById(R.id.btnnagta);

        buttonopenhitdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),HitDat.class);
                startActivity(in);
            }
        });

        buttongapbung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),GapBung.class);
                startActivity(in);
            }
        });

        buttonsquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),Squat.class);
                startActivity(in);
            }
        });

        buttonplank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),Plank.class);
                startActivity(in);
            }
        });
        buttonnhayday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),NhayDay.class);
                startActivity(in);
            }
        });

        buttonnagta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),TapTa.class);
                startActivity(in);
            }
        });


        return view;
    }
}