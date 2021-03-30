package com.leyline.salmoncookies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreViewModel;
import com.leyline.salmoncookies.store.StorePageAdapter;

import java.util.List;

public class StoreListFragment extends Fragment {
    private StoreViewModel storeViewModel;
    private StorePageAdapter storeViewPager;

    public StoreListFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        observerSetup();
        recyclerSetup();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void observerSetup() {
        storeViewModel = new ViewModelProvider(requireActivity()).get(StoreViewModel.class);
        storeViewModel.getAllStores().observe(getViewLifecycleOwner(), new Observer<List<Store>>() {
            @Override
            public void onChanged(List<Store> stores) {
                storeViewPager.setStoreList(stores);
            }
        });
        storeViewModel.getStoreSearch().observe(getViewLifecycleOwner(), new Observer<List<Store>>() {
            @Override
            public void onChanged(List<Store> stores) {
                Toast.makeText(getContext(), "Search Store changed? Whatever that means", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void recyclerSetup(){
        RecyclerView recyclerView;
        storeViewPager = new StorePageAdapter(R.layout.fragment_store_list);
        recyclerView = getView().findViewById(R.id.rvStore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(storeViewPager);
    }


}