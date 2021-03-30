package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StoreDAO {
    @Insert
    void addStore(Store store);

    @Update
    void updateStore(Store store);

    @Delete
    void deleteStore(Store store);

    @Query("DELETE FROM store_table")
    void deleteAllStores();

    @Query("SELECT * FROM store_table WHERE store_location = :name")
    List<Store> findStore(String name);

    @Query("SELECT * FROM store_table ORDER BY store_location DESC")
    LiveData<List<Store>> getAllStores();
}
