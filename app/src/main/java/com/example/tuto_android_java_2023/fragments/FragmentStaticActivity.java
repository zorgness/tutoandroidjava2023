package com.example.tuto_android_java_2023.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tuto_android_java_2023.R;

public class FragmentStaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_static);

        Button btnNext = findViewById(R.id.btn_fragment_static);

        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(this, FragmentStaticActivity2.class));
        });
    }
}