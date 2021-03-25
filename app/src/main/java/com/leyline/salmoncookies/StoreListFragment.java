package com.leyline.salmoncookies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    private StoreModel storeModel;
    private RecyclerView storeViewPager;

    public StoreListFragment(){}
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_list, container, false);
        bindUI(view);
        storeModel = new ViewModelProvider(requireActivity()).get(StoreModel.class);
        storeModel.getStores().observe(getViewLifecycleOwner(), stores -> {
            startViewPager(stores);
        });
        return view;
    }

    private void bindUI(View view){
        storeViewPager = view.findViewById(R.id.rvStore);
    }
    private void startViewPager(List<Store> stores) {
        this.storeViewPager.setAdapter(new StorePageAdapter(stores));
        this.storeViewPager.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}