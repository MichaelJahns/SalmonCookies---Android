package com.leyline.salmoncookies.util;

import androidx.lifecycle.ViewModelProvider;

import com.leyline.salmoncookies.store.StoreRepository;

public final class StoreModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final StoreRepository storeRepository;
    public StoreModelFactory(StoreRepository storeRepository){
        super();
        this.storeRepository = storeRepository;
    }
}
