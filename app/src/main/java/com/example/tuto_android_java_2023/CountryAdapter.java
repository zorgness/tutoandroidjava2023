package com.example.tuto_android_java_2023;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryHolder>{
    private final ArrayList<Country> countries;
    private MyCallback onItemClicked, onNameClicked;
    private int positionToUpdate;

    public CountryAdapter() {
        countries = new ArrayList<>();
        countries.add(new Country("france","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_France.svg/2560px-Flag_of_France.svg.png"));
        countries.add(new Country("china","https://cdn.britannica.com/90/7490-004-BAD4AA72/Flag-China.jpg"));
        countries.add(new Country("mexico","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Denmark.svg/2560px-Flag_of_Denmark.svg.png"));
    }

    public void setCallback(MyCallback onItemClicked) {
        this.onItemClicked = onItemClicked;

    }
    public void setCallback2(MyCallback onNameClicked) {
        this.onNameClicked = onNameClicked;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ViewGroup est temporaire
        //representation de l'xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_country, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder countryHolder, int position) {
        Country country = countries.get(position);
        countryHolder.countryName.setText(country.getName());

        if(country.getUrlImage() != null) {
            String url = country.getUrlImage().isEmpty() ? "lol" : country.getUrlImage();

               Picasso.get()
                .load(url).placeholder(R.drawable.drink)
                .resize(300, 300)
                .into(countryHolder.countryImage);
        }

        //un listener est une interface
        //TOAST
        countryHolder.countryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClicked != null)
                    onItemClicked.onAction(country.getName());
            }
        });

        //UPDATE FORM
        countryHolder.countryName.setOnClickListener(view -> {
            if(onNameClicked != null) {
                onNameClicked.onAction(country);
                //positionToUpdate = countries.indexOf(country);
                positionToUpdate = countryHolder.getAdapterPosition();
            }
        });

        //DELETE
        countryHolder.countryTrash.setOnClickListener(view -> deleteCountry(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void addCountry(Country country) {
        countries.add(country);
        notifyItemInserted(getItemCount() - 1);
    }

    public void updateCountry(Country country) {
        /*Country countryToEdit = countries.get(positionToUpdate);
        countryToEdit.setName(country.getName());
        countryToEdit.setUrlImage(country.getUrlImage());*/
        countries.set(positionToUpdate, country);
        notifyItemChanged(positionToUpdate);
    }

    public void deleteCountry(int position) {
        countries.remove(position);
        notifyItemRemoved(position);
    }
}
