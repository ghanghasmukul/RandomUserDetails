package com.mukul.randomuserdetails.dao;
import com.mukul.randomuserdetails.models.Result;
import java.util.List;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface daoInterface {


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insertOneQuote(Result result);

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insertListOfResults(List<Result> resultListList);

        @Query("SELECT * FROM users_table WHERE savedAt > :oneWeekAgoInMillis")
        List<Result> getQuotesFromLastOneWeek(long oneWeekAgoInMillis);

        @Query("SELECT * FROM users_table WHERE email = :email")
        Result getResultByID(String email);

        @Query("SELECT * FROM users_table order by savedAt desc")
        List<Result> getAllSaveddetails();

        @Delete
        void deleteOneuser(Result result);

        @Update
        void updateuser(Result result);
}

