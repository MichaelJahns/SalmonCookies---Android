package com.leyline.salmoncookies.store;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Store.class}, version = 1)
public abstract class StoreDatabase extends RoomDatabase {
    public abstract StoreDAO storeDAO();
    private static StoreDatabase INSTANCE;

    static StoreDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (StoreDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StoreDatabase.class,
                            "store_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
