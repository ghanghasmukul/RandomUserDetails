package com.mukul.randomuserdetails.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mukul.randomuserdetails.models.Dob;
import com.mukul.randomuserdetails.models.Name;

import java.lang.reflect.Type;

public class DOBTypeConverter {
    private static Gson gson = new Gson();
    private static Type type = new TypeToken<Dob>(){}.getType();
    @TypeConverter
    public static Dob stringToDob(String json) {
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String DobToString(Dob dob) { return gson.toJson(dob, type);
    }

}
