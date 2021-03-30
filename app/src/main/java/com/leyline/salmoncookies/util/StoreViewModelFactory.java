package com.leyline.salmoncookies.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;

import com.leyline.salmoncookies.store.StoreRepository;
import com.leyline.salmoncookies.store.StoreViewModel;

import org.jetbrains.annotations.NotNull;

public class StoreViewModelFactory extends NewInstanceFactory {

    @NonNull
    private final Application mApplication;

    public StoreViewModelFactory(@NotNull Application application){
        this.mApplication = application;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new StoreViewModel(mApplication);
    }
}
