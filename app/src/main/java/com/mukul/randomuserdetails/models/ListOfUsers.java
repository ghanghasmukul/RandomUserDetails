
package com.mukul.randomuserdetails.models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListOfUsers implements Serializable
{

    @SerializedName("results")
    @Expose
    private List<Result> results;
    @SerializedName("info")
    @Expose
    private Info info;
    private final static long serialVersionUID = 842221526670584395L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListOfUsers() {
    }


    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}

