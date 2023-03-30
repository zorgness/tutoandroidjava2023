package com.example.tuto_android_java_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class CountryFormActivity extends AppCompatActivity {

    private EditText etCountryName, etCountryUrl;

    private ImageView flagVisualizer;

    public static final String KEY_COUNTRY = "key country";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_form2);

        etCountryName = findViewById(R.id.et_country_form_name);
        etCountryUrl = findViewById(R.id.et_country_form_url);
        flagVisualizer = findViewById(R.id.flag_visualizer_country_form);
        Button buttonFormActivity = findViewById(
                R.id.button_country_form_activity
        );

        if(getIntent().getExtras() != null) {
            etCountryName.setText(getIntent().getStringExtra("name"));
            etCountryUrl.setText(getIntent().getStringExtra("url"));
            buttonFormActivity.setText("mise à jour");

        }

        buttonFormActivity.setOnClickListener(view -> {
            String name = etCountryName.getText().toString().toLowerCase().trim();
            String url = etCountryUrl.getText().toString().trim();
            Intent formActivityIntent = new Intent();
            if(!name.isEmpty() && !url.isEmpty()) {
                Country country = new Country(name, url);
                setResult(RESULT_OK, formActivityIntent.putExtra(KEY_COUNTRY, country));
            } else {
                setResult(RESULT_CANCELED, formActivityIntent);
            }

            finish();
        });


        etCountryUrl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocus) {
               String urlImageToVisualize = etCountryUrl.getText().toString().trim();
               if(!urlImageToVisualize.isEmpty() && !isFocus) {
                   Picasso.get()
                           .load(urlImageToVisualize)
                           .resize(300, 300)
                           .error(R.drawable.empty)
                           .into(flagVisualizer);
                   //flagVisualizer.setVisibility(View.VISIBLE);
               } else if (urlImageToVisualize.isEmpty()) {
                   //flagVisualizer.setVisibility(View.INVISIBLE);
                   Picasso.get()
                           .load(android.R.color.transparent)
                           .resize(300, 300)
                           .into(flagVisualizer);
               }
            }
        });
    }
}