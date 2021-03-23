package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public final class StoreDAO {
    private List<Store> storeList;
    private final MutableLiveData<List<Store>> stores;

    public final LiveData<List<Store>> getStores() {
        MutableLiveData<List<Store>> data = this.stores;
        if(data == null){
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.michaeljahns.namespace.scenario.Scenario>>");
        } else{
            return data;
        }
    }

    public void addStore(Store store) {
        storeList.add(store);
        updateStores();
    }

    private void updateStores(){
        this.stores.setValue(this.storeList);
    }

    public StoreDAO(){
        this.storeList = new ArrayList<>();
        this.stores = new MutableLiveData<>();
        this.initStores();
    }

    public void initStores() {
        this.storeList = StoreFactory.INSTANCE.getStores();
    }
}
