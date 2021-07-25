package com.mukul.randomuserdetails.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mukul.randomuserdetails.models.Picture;

import java.lang.reflect.Type;

public class PictureTypeConverter {

    private static Gson gson = new Gson();
    private static Type type = new TypeToken<Picture>(){}.getType();
    @TypeConverter
    public static Picture stringToPicture(String json) {
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String PictureToString(Picture picture) { return gson.toJson(picture, type);
    }

}

