package com.leyline.salmoncookies.store;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                            "store_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(populateCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback populateCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private StoreDAO storeDAO;
        private PopulateDbAsyncTask(StoreDatabase db){
            storeDAO = db.storeDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            storeDAO.addStore(new Store("Sequim", 10.4f, 3, 17));
            storeDAO.addStore(new Store("Port Angeles", 12.5f, 7, 15));
            storeDAO.addStore(new Store("Forks", 3.5f, 3, 9));
            storeDAO.addStore(new Store("Jamestown", 22.2f, 15, 23));
            return null;
        }
    }
}
