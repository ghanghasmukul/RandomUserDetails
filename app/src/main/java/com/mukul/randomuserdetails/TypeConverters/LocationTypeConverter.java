package com.mukul.randomuserdetails.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mukul.randomuserdetails.models.Location;

import java.lang.reflect.Type;

public class LocationTypeConverter {

    private static Gson gson = new Gson();
    private static Type type = new TypeToken<Location>(){}.getType();

    @TypeConverter
    public static Location stringToLocation(String json) {
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String locationToString(Location location) {
        return gson.toJson(location, type);
    }
}
