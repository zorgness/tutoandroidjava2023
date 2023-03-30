package com.example.tuto_android_java_2023;

import static android.content.RestrictionsManager.RESULT_ERROR;
import static com.example.tuto_android_java_2023.FormActivity.KEY_PERSON;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.text.Normalizer;

public class SecondActivity extends AppCompatActivity {

    private EditText editText;

    public static final String KEY_NAME = "key name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.et_second_message);


        Button buttonFormActivity = findViewById(
                R.id.button_form_activity
        );
        buttonFormActivity.setOnClickListener(view -> {
            String nom = editText.getText().toString().trim();
            Intent formActivityIntent = new Intent();
            if(!nom.isEmpty()) {
                setResult(RESULT_OK, formActivityIntent.putExtra(KEY_NAME, nom ));
            } else {
                setResult(RESULT_CANCELED, formActivityIntent.putExtra(KEY_NAME, nom ));
            }



            finish();
        });

    }







}