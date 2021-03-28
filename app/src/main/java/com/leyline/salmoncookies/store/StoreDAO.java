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

    @Query("SELECT * FROM stores")
    LiveData<List<Store>> getAllStores();



}
