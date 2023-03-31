package com.example.tuto_android_java_2023.fragments2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tuto_android_java_2023.MyCallback;
import com.example.tuto_android_java_2023.R;

public class PinkFragment extends Fragment {


    private MyCallback onBtnToastClicked;

    public PinkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pink, container, false);

        Button btnToast = view.findViewById(R.id.btn_toast_fragment);
        btnToast.setOnClickListener(v -> {
            onBtnToastClicked.onAction("COUCOU DE FRAGMENT ROSE");
        });

        return view;
    }

    public void setOnBtnToastClicked(MyCallback onBtnToastClicked) {
        this.onBtnToastClicked = onBtnToastClicked;
    }
}