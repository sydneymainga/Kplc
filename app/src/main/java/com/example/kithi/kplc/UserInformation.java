package com.example.kithi.kplc;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kithi on 11/21/2016.
 */

public class UserInformation {
    public String name;
    public String location;
    public  String phone;
   // public Map<String, Boolean> stars = new HashMap<>();


    public UserInformation(){

    }

    public UserInformation(String location, String name, String phone) {
        this.location = location;
        this.name = name;
        this.phone = phone;
    }

   /* @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        //result.put("uid", uid);
       // result.put("author", author);
        result.put("location", location);
        result.put("name", name);
        result.put("phone", phone);
        //result.put("stars", stars);

        return result;
    }*/
}
