package com.mukul.randomuserdetails.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mukul.randomuserdetails.models.Name;
import com.mukul.randomuserdetails.models.Picture;

import java.lang.reflect.Type;

public class NameTypeConverter {

    private static Gson gson = new Gson();
    private static Type type = new TypeToken<Name>(){}.getType();
    @TypeConverter
    public static Name stringToName(String json) {
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String NameToString(Name name) { return gson.toJson(name, type);
    }

}

