package com.mukul.randomuserdetails.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mukul.randomuserdetails.dao.daoInterface;
import com.mukul.randomuserdetails.models.Result;


@Database(entities = {Result.class}, version = 1)
    public abstract class UsersDatabase extends RoomDatabase {


        public abstract daoInterface Dao();

        public static UsersDatabase INSTANCE;

        public static synchronized UsersDatabase getInstance(Context context) {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UsersDatabase.class, "database")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }

            return INSTANCE;
        }
}
