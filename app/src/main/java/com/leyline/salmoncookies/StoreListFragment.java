package com.leyline.salmoncookies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreModel;
import com.leyline.salmoncookies.store.StorePageAdapter;
import com.leyline.salmoncookies.util.InjectorUtilities;
import com.leyline.salmoncookies.util.StoreModelFactory;

import java.util.List;

public class StoreListFragment extends Fragment {
    private List<Store> stores;
    private StoreModel storeModel;
    private final StoreModelFactory storeModelFactory;
    private RecyclerView storeViewPager;

    public StoreListFragment() {
        this.storeModelFactory = InjectorUtilities.instance.provideStoreModelFactory();
        this.storeModel = new ViewModelProvider(this, storeModelFactory).get(StoreModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_store_list, null);
        this.storeViewPager = root.findViewById(R.id.rvStore);
        storeModel.getStores().observe(getViewLifecycleOwner(), stores -> {
            startViewPager(stores);
        });
        return root;
    }

    private void startViewPager(List<Store> stores) {
        this.storeViewPager.setAdapter(new StorePageAdapter(stores));
//        this.storeViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }
}