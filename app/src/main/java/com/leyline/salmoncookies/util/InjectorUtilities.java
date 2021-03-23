package com.leyline.salmoncookies.util;

import com.leyline.salmoncookies.store.StoreDatabase;
import com.leyline.salmoncookies.store.StoreRepository;

public final class InjectorUtilities {
    public static final InjectorUtilities instance;

    public final StoreModelFactory provideStoreModelFactory(){
        StoreRepository storeRepository = StoreRepository.getInstance(StoreDatabase.getInstance().getStoreDAO());
        return new StoreModelFactory(storeRepository);
    }
    static {
      instance = new InjectorUtilities();
    }
}
