package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StoreDAO {

    @Insert
    void addStore(Store store);

    @Query("DELETE FROM stores WHERE storeLocation = :name")
    void deleteStore(String name);

    @Query("SELECT * FROM stores WHERE storeLocation = :name")
    List<Store> findStore(String name);
    @Query("SELECT * FROM stores")
    LiveData<List<Store>> getAllStores();



}
