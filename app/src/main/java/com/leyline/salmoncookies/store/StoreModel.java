package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class StoreModel extends ViewModel {
    private final StoreRepository storeRepository;

    public final LiveData<List<Store>> getStores() { return this.storeRepository.getStores();}
    public final void addStore(Store store) { this.storeRepository.addStore(store);}

    public StoreModel(){
        super();
        this.storeRepository = StoreRepository.getInstance(StoreDatabase.getInstance().getStoreDAO());
    }
    public StoreModel(StoreRepository storeRepository){
        super();
        this.storeRepository = storeRepository;
    }
}
