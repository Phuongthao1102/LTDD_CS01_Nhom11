package com.example.ungdungtaptheduc.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ungdungtaptheduc.R;
import com.example.ungdungtaptheduc.WebViewActivity;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    Button btnDiLun;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        btnDiLun = root.findViewById(R.id.btn_dilun);

        final TextView textView = root.findViewById(R.id.text_slideshow);

        btnDiLun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getActivity(), WebViewActivity.class);
                startActivity(i);
            }
        });
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}