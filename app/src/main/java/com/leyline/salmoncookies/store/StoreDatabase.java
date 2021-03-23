package com.leyline.salmoncookies.store;

public final class StoreDatabase {
    private StoreDAO storeDAO;
    private static volatile StoreDatabase instance;

    public final StoreDAO getStoreDAO(){
        return this.storeDAO;
    }
    public synchronized static StoreDatabase getInstance() {
        if(instance == null){
            instance = new StoreDatabase();
        }
        return instance;
    }

    private StoreDatabase(){
        this.storeDAO = new StoreDAO();
    }
}
