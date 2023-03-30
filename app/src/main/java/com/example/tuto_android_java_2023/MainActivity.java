package com.example.tuto_android_java_2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CountryAdapter countryAdapter;
    private final int LAUNCH_COUNTRY_NEW_FORM_ACTIVITY = 243;
    private final int LAUNCH_COUNTRY_EDIT_FORM_ACTIVITY = 255;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //HEADER
        ImageView imageView = findViewById(R.id.profile_image);
        Picasso.get()
                .load("https://media.istockphoto.com/id/1433039224/photo/blue-user-3d-icon-person-profile-concept-isolated-on-white-background-with-social-member.jpg?b=1&s=170667a&w=0&k=20&c=X-ZNF80_ASKvWpbOICHC8Pf27CFCRyh7Ce9SDVopjZg=")
                .resize(300, 300)
                .into(imageView);

        recyclerView = (RecyclerView) findViewById(R.id.rv_country);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryAdapter = new CountryAdapter();

        //TOAST
        countryAdapter.setCallback(o -> Toast.makeText(this, (String) o, Toast.LENGTH_SHORT).show());

        //NEW FORM
        Button btnAddCountry = findViewById(R.id.button_add_country);
        btnAddCountry.setOnClickListener(v -> {
            Intent countryFormActivityIntent = new Intent(
                    this, CountryFormActivity.class

            );
            startActivityForResult(countryFormActivityIntent, LAUNCH_COUNTRY_NEW_FORM_ACTIVITY);
        });


        //EDIT FORM
        countryAdapter.setCallback2(country -> {
            Country toEdit = (Country) country;
            Intent editCountryFormActivityIntent = new Intent(
                    this, CountryFormActivity.class

            );
            editCountryFormActivityIntent.putExtra("name", toEdit.getName());
            editCountryFormActivityIntent.putExtra("url", toEdit.getUrlImage());
            //editCountryFormActivityIntent.putExtra("countryObject", toEdit);
            startActivityForResult(editCountryFormActivityIntent, LAUNCH_COUNTRY_EDIT_FORM_ACTIVITY);
        });

        recyclerView.setAdapter(countryAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_COUNTRY_NEW_FORM_ACTIVITY) {
            if (resultCode == RESULT_OK && data != null) {
                Country country = data.getParcelableExtra(CountryFormActivity.KEY_COUNTRY);
                countryAdapter.addCountry(country);
                recyclerView.scrollToPosition(countryAdapter.getItemCount() - 1);

            } else if (resultCode == RESULT_CANCELED) {
                String msg = data == null ? "cancelled via back" : "cancelled via button";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == LAUNCH_COUNTRY_EDIT_FORM_ACTIVITY) {
            if (resultCode == RESULT_OK && data != null) {
                Country country = data.getParcelableExtra(CountryFormActivity.KEY_COUNTRY);
                countryAdapter.updateCountry(country);

                recyclerView.scrollToPosition(countryAdapter.getItemCount() - 1);

            }
        }
    }
}