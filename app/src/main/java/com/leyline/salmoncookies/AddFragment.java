package com.leyline.salmoncookies;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreModel;

public class AddFragment extends Fragment {
    private StoreModel storeModel;
    private FloatingActionButton fab;
    EditText etStoreLocation, etStoreAverageSales, etStoreMinCust, etStoreMaxCust;

    public AddFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        storeModel = new ViewModelProvider(requireActivity()).get(StoreModel.class);
        bindUI(view);
        return view;
    }

    private void bindUI(View view){
        this.etStoreLocation = view.findViewById(R.id.etStoreLocation);
        this.etStoreAverageSales = view.findViewById(R.id.etStoreAverageSales);
        this.etStoreMinCust = view.findViewById(R.id.etStoreMinCust);
        this.etStoreMaxCust = view.findViewById(R.id.etStoreMaxCust);
        this.fab = view.findViewById(R.id.fab14);
        this.fab.setOnClickListener(v -> {
            Store userStore = getUserStore(v);
            storeModel.addStore(userStore);
        });
    }


    public Store getUserStore(View view) {
        String location = etStoreLocation.getText().toString();
        Float averageSales = Float.parseFloat(etStoreAverageSales.getText().toString());
        int minCust = Integer.parseInt(etStoreMinCust.getText().toString());
        int maxCust = Integer.parseInt(etStoreMaxCust.getText().toString());
        Store userStore = new Store(location, averageSales, minCust, maxCust);
        return userStore;
    }
}