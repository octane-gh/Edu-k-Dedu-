package com.example.dbdog;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Dog.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DogDAO dogDAO();

    public static final String DB_NAME = "Dog.db";
    private static volatile AppDatabase INSTANCE = null;

    synchronized static AppDatabase get(Context context) {
        if (INSTANCE == null) INSTANCE = create(context, false);
        return INSTANCE;
    }

    static AppDatabase create(Context context, boolean memoryOnly) {
        RoomDatabase.Builder<AppDatabase> b;
        if (memoryOnly)
            b = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class);
        else b = Room.databaseBuilder(context, AppDatabase.class, DB_NAME);
        return (b.build());
    }
}
