package com.example.elcodelab;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton ImgBtn = view.findViewById(R.id.homeBtn);
        ImgBtn.setOnClickListener((v ->{
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        }));


        return view;
    }
}