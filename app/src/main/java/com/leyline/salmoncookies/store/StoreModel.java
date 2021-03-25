package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StoreModel extends ViewModel {
    private List<Store> storeList;
    private MutableLiveData<List<Store>> stores;

    public LiveData<List<Store>> getStores(){
        return stores;
    }

    public void addStore(Store store) {
        storeList.add(store);
        updateStores();
    }
    private void updateStores(){
        this.stores.setValue(this.storeList);
    }

    private @NotNull List<Store> initStoreList() {
        return StoreFactory.INSTANCE.getStores();
    }

    public StoreModel(){
            stores = new MutableLiveData<>();
            storeList = initStoreList();
            updateStores();
    }
}
