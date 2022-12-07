package com.unitapplications.memeapp.Models;

public class MemeModel {

       private String url;

    public MemeModel() {
    }

    public MemeModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}