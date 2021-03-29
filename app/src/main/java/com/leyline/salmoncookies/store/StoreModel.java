package com.leyline.salmoncookies.store;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StoreModel extends ViewModel {
    private StoreRepository storeRepository;
    private LiveData<List<Store>> allStores;
    private MutableLiveData<List<Store>> stores;

    public LiveData<List<Store>> getAllStores(){
        return allStores;
    }
    public MutableLiveData<List<Store>> getStores(){
        return stores;
    }

    public StoreModel(Application application){
        storeRepository = new StoreRepository(application);
        allStores = storeRepository.;
        stores = storeRepository.s
    }
}
