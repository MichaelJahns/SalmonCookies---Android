package com.leyline.salmoncookies.store;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StoreRepository {
    private final StoreDAO storeDAO;
    private static volatile StoreRepository instance;

    public synchronized static StoreRepository getInstance(StoreDAO storeDAO) {
        if(instance == null){
            instance = new StoreRepository(storeDAO);
        }
        return instance;
    }

    public void addStore(Store store) {
        this.storeDAO.addStore(store);
    }

    public LiveData<List<Store>> getStores() {
        return this.storeDAO.getStores();
    }
    public void initStores() {
        this.storeDAO.initStores();
    }

    private StoreRepository(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
    }


}
