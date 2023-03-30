package com.example.tuto_android_java_2023;

//item.xml holder adapter dataclass recyclerview set Layout

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Country  implements Parcelable {

    private String name;
    //private int resId;
    private String urlImage;

   /* public Country(String name, int resId) {
        this.name = name;
        this.resId = resId;

    }*/

    public Country(String name, String urlImage) {
        this.name = name;
        this.urlImage = urlImage;

    }

    protected Country(Parcel in) {
        name = in.readString();
        urlImage = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(urlImage);
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };


    public String getName() {
        return name.substring(0 ,1).toUpperCase() + name.substring(1);
    }

   /* public int getResId() {
        return resId;
    }*/

    public String getUrlImage() {
        return urlImage;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }


}
