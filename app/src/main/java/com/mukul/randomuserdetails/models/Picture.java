
package com.mukul.randomuserdetails.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture implements Serializable
{

    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    private final static long serialVersionUID = -7911330735700601405L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Picture() {
    }

    /**
     * 
     * @param thumbnail
     * @param large
     * @param medium
     */
    public Picture(String large, String medium, String thumbnail) {
        super();
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
