package com.ferhatergun.javamvp.home.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ferhat on 11/28/2017.
 */

public class News {
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("title")
    private String title;
    @SerializedName("summary")
    private String summary;
    @SerializedName("content")
    private String content;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("json_url")
    private String jsonUrl;
    @SerializedName("main_image")
    private NewsImage mainImage;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public NewsImage getMainImage() {
        return mainImage;
    }

    public void setMainImage(NewsImage mainImage) {
        this.mainImage = mainImage;
    }
}
