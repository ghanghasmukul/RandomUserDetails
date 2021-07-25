
package com.mukul.randomuserdetails.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone implements Serializable
{

    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("description")
    @Expose
    private String description;
    private final static long serialVersionUID = 5501969148330984198L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Timezone() {
    }

    /**
     * 
     * @param offset
     * @param description
     */
    public Timezone(String offset, String description) {
        super();
        this.offset = offset;
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
