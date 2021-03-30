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
import android.widget.Button;
import android.widget.Toast;

import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreViewModel;
import com.leyline.salmoncookies.store.StorePageAdapter;
import com.leyline.salmoncookies.util.StoreViewModelFactory;

import java.util.List;

public class StoreListFragment extends Fragment {
    private StoreViewModel storeViewModel;
    private StoreViewModelFactory factory;
    private RecyclerView recyclerView;
    private StorePageAdapter storeViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_list, container, false);
        recyclerView = view.findViewById(R.id.rvStore);
        List<Store> fake = observerSetup();
        recyclerSetup(fake);
        Button btn0 = view.findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeViewModel.deleteAllStores();
            }
        });
        return view;
    }

    private List<Store> observerSetup() {
        factory = new StoreViewModelFactory(getActivity().getApplication());
        storeViewModel = new ViewModelProvider(requireActivity(), factory).get(StoreViewModel.class);
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

        return storeViewModel.getAllStores().getValue();
    }

    private void recyclerSetup(List<Store> stores){
        storeViewPager = new StorePageAdapter(stores);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(storeViewPager);
    }


}