package com.example.ruhealthytwo;

import android.net.Uri;

import com.google.firebase.database.IgnoreExtraProperties;

import org.json.JSONObject;

import java.util.ArrayList;

// [START rtdb_user_class]
//@IgnoreExtraProperties
//public class User {
//
//
//    private String uid;
//    private String email;
//    private JSONObject recipes;
//
//    private int dailyCaloricIntake;
//
//    private int proteinIntake;
//
//    private int height;
//
//    private int weight;
//
//
//
//    public User() {
//        // Default constructor required for calls to DataSnapshot.getValue(User.class)
//    }
//
//    public User(String uid, String email, int dailyCaloricIntake, int proteinIntake, int height, int weight) {
//        this.uid = uid;
//        this.email = email;
//        this.dailyCaloricIntake = dailyCaloricIntake;
//        this.proteinIntake = proteinIntake;
//        this.height = height;
//        this.weight = weight;
//
//
//    }
//
//    public String getUid() {
//        return uid;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public int getDailyCaloricIntake() {
//        return dailyCaloricIntake;
//    }
//
//    public int getProteinIntake() {
//        return proteinIntake;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setDailyCaloricIntake(int dailyCaloricIntake) {
//        this.dailyCaloricIntake = dailyCaloricIntake;
//    }
//
//    public void setProteinIntake(int proteinIntake) {
//        this.proteinIntake = proteinIntake;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//
//}

@IgnoreExtraProperties
public class User {


    private String uid;
    private String email;
    private JSONObject recipes;

    private String aboutMe;

    private ArrayList<String> interests;

    private Uri photoUrl;

    private float latitude;

    private float longitude;



    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String uid, String email, String aboutMe, ArrayList<String> interests, Uri photoUrl, float latitude, float longitude) {
        this.uid = uid;
        this.email = email;
        this.aboutMe = aboutMe;
        this.interests = interests;
        this.photoUrl = photoUrl;
        this.latitude = latitude;
        this.longitude = longitude;



    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public Uri getPhotoUrl() {
        return photoUrl;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public void setPhotoUrl(Uri photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }




}