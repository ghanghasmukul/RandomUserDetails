
package com.mukul.randomuserdetails.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Coordinates implements Serializable
{

    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    private final static long serialVersionUID = -7388827585469997538L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coordinates() {
    }

    /**
     * 
     * @param latitude
     * @param longitude
     */
    public Coordinates(String latitude, String longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
