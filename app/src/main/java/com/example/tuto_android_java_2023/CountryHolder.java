package com.example.tuto_android_java_2023;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CountryHolder extends RecyclerView.ViewHolder {
    public ConstraintLayout countryLayout;
    public TextView countryName;
    public ImageView countryImage, countryTrash;

    public CountryHolder(@NonNull View itemView) {
        super(itemView);
        countryLayout = (ConstraintLayout) itemView.findViewById(R.id.country_layout);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        countryImage = (ImageView) itemView.findViewById(R.id.country_image);
        countryTrash = (ImageView) itemView.findViewById(R.id.iv_delete_country);

    }

}
