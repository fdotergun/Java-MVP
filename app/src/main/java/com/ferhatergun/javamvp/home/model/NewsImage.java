package com.ferhatergun.javamvp.home.model;

/**
 * Created by ferhat on 11/28/2017.
 */

public class NewsImage {

    private String url;
    private String height;
    private String width;

    public NewsImage(String url,String height,String width){
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
