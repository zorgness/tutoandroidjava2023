package com.example.tuto_android_java_2023.fragments2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tuto_android_java_2023.R;

import org.w3c.dom.Text;


public class GreenFragment extends Fragment {

    private final String title;
    public GreenFragment(String title) {
        this.title = title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_green, container, false);
        TextView tvTitle = view.findViewById(R.id.tv_title_green_frag);
        tvTitle.setText(title);

        return view;
    }
}