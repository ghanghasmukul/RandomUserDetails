
package com.mukul.randomuserdetails.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.TypeConverters;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mukul.randomuserdetails.TypeConverters.DOBTypeConverter;
import com.mukul.randomuserdetails.TypeConverters.LocationTypeConverter;
import com.mukul.randomuserdetails.TypeConverters.NameTypeConverter;
import com.mukul.randomuserdetails.TypeConverters.PictureTypeConverter;

@Entity(tableName = "users_table", primaryKeys = {"gender", "name", "email"})
public class Result implements Serializable
{

    @NonNull
    @SerializedName("gender")
    @Expose
    private String gender;
    @TypeConverters(NameTypeConverter.class)
    @SerializedName("name")
    @Expose
    @NonNull
    private Name name;
    @TypeConverters(LocationTypeConverter.class)
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    @NonNull
    private String email;
    @TypeConverters(DOBTypeConverter.class)
    @SerializedName("dob")
    @Expose
    private Dob dob;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @TypeConverters(PictureTypeConverter.class)
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;
    private Long savedAt = System.currentTimeMillis();

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public Name getName() {
        return name;
    }

    public void setName(@NonNull Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public Long getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Long savedAt) {
        this.savedAt = savedAt;
    }
}
