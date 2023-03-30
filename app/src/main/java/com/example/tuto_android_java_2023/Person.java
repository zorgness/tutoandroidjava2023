package com.example.tuto_android_java_2023;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Person implements Parcelable {
    private String nom;
    private String prenom;
    private int age;

    public Person(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeInt(age);
    }

    protected Person(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };


    @NonNull
    @Override
    public String toString() {
        return "Bonjour " + prenom + " " + nom + " tu es " + (age > 18 ? "majeur" : "mineur");
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;

    }




}
