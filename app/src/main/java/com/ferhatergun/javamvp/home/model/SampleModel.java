package com.ferhatergun.javamvp.home.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ferhat on 11/25/2017.
 */

public class SampleModel {

    @SerializedName("userName")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("userId")
    private String id;

    public SampleModel(String name,String email,String id){
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
