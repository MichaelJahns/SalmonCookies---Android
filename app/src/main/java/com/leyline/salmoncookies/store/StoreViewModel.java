package com.leyline.salmoncookies.store;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

public class StoreViewModel extends ViewModel {
    private StoreRepository storeRepository;
    private LiveData<List<Store>> allStores;
    private MutableLiveData<List<Store>> storeSearch;

    public LiveData<List<Store>> getAllStores(){
        return allStores;
    }
    public MutableLiveData<List<Store>> getStoreSearch(){
        return storeSearch;
    }
    public void insertStore(Store store){
        storeRepository.insert(store);
    }
    public void updateStore(Store store){ storeRepository.update(store);}
    public void deleteStore(Store store){
        storeRepository.delete(store);
    }
    public void deleteAllStores(){ storeRepository.deleteAllStores();}

    public StoreViewModel(@NonNull Application application){
        storeRepository = new StoreRepository(application);
        allStores = storeRepository.getAllStores();
        storeSearch = storeRepository.getStoreSearch();
    }
}
