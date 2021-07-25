
package com.mukul.randomuserdetails.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Dob implements Serializable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("age")
    @Expose
    private Integer age;
    private final static long serialVersionUID = 4564829657631579199L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Dob() {
    }

    /**
     * 
     * @param date
     * @param age
     */
    public Dob(String date, Integer age) {
        super();
        this.date = date;
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
