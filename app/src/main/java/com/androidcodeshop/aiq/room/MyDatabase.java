package com.androidcodeshop.aiq.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.androidcodeshop.aiq.model.QuestionAnswerModel;

@Database(entities = {QuestionAnswerModel.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract AiqDao aiqDao();

    private static volatile MyDatabase INSTANCE;

    public static MyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "AIQ_TABLE")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
