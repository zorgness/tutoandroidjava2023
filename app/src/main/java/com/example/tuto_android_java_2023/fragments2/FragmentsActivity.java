package com.example.tuto_android_java_2023.fragments2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.tuto_android_java_2023.MyCallback;
import com.example.tuto_android_java_2023.R;

public class FragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        Button btnGreen = findViewById(R.id.btn_green);
        Button btnPink = findViewById(R.id.btn_pink);


        btnGreen.setOnClickListener(v -> {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            GreenFragment greenFragment = new GreenFragment("Titre dynamique de Fragment vert");
            ft.replace(R.id.frame_layout, greenFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            try {
                ft.commit();
            } catch (Exception e) {
                //Log.d(TAG, e.getMessage());
            }

        });


        btnPink.setOnClickListener(v -> {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            PinkFragment pinkFragment = new PinkFragment();

            pinkFragment.setOnBtnToastClicked(o -> {
                Toast.makeText(this, (String) o, Toast.LENGTH_SHORT).show();
            });

            ft.replace(R.id.frame_layout, pinkFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            try {
                ft.commit();
            } catch (Exception e) {
                //Log.d(TAG, e.getMessage());
            }

        });
    }
}