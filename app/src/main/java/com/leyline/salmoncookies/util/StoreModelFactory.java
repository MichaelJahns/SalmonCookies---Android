package com.leyline.salmoncookies.util;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.leyline.salmoncookies.store.StoreModel;
import com.leyline.salmoncookies.store.StoreRepository;

public final class StoreModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final StoreRepository storeRepository;

    public ViewModel create(){
        return new StoreModel(this.storeRepository);
    }
    public StoreModelFactory(StoreRepository storeRepository){
        super();
        this.storeRepository = storeRepository;
    }
}
