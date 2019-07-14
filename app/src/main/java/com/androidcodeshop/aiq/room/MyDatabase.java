package com.androidcodeshop.aiq.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
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
