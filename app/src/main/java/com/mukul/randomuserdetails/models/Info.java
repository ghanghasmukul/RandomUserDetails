
package com.mukul.randomuserdetails.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info implements Serializable
{

    @SerializedName("seed")
    @Expose
    private String seed;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("version")
    @Expose
    private String version;
    private final static long serialVersionUID = -7147075790606126727L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Info() {
    }

    /**
     * 
     * @param seed
     * @param page
     * @param results
     * @param version
     */
    public Info(String seed, Integer results, Integer page, String version) {
        super();
        this.seed = seed;
        this.results = results;
        this.page = page;
        this.version = version;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
