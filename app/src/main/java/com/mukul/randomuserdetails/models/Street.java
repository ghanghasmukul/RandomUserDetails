
package com.mukul.randomuserdetails.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Street implements Serializable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 6493868861775422707L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Street() {
    }

    /**
     * 
     * @param number
     * @param name
     */
    public Street(Integer number, String name) {
        super();
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
