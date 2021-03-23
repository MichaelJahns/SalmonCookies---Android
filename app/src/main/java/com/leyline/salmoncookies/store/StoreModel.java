package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class StoreModel extends ViewModel {
    private StoreRepository storeRepository;

    public final LiveData<List<Store>> getStores() { return this.storeRepository.getStores();}
    public final void initStores(){this.storeRepository.initStores();}
    public final void addStore(Store store) { this.storeRepository.addStore(store);}

    public StoreModel(){}

    public StoreModel(StoreRepository storeRepository){
        super();
        this.storeRepository = storeRepository;
    }
}
