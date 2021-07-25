
package com.mukul.randomuserdetails.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Id implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;
    private final static long serialVersionUID = -6987422801313260591L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Id() {
    }

    /**
     * 
     * @param name
     * @param value
     */
    public Id(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
