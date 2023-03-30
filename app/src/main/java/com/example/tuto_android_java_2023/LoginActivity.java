package com.example.tuto_android_java_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEdt, passwordEdt;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginButton.setOnClickListener(v -> {
            setVariable();
        });

    }

    public void setVariable() {
        String email = emailEdt.getText().toString().trim();
        String password = passwordEdt.getText().toString().trim();
        if(email.isEmpty() && password.isEmpty() ) {
            Toast.makeText(this,"please fill the form", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void initView() {
        emailEdt = findViewById(R.id.edit_login_email);
        passwordEdt = findViewById(R.id.edit_login_password);
        loginButton = findViewById(R.id.button_login);
    }





}