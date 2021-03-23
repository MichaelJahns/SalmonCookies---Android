package com.leyline.salmoncookies;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreFactory;
import com.leyline.salmoncookies.store.StoreModel;
import com.leyline.salmoncookies.store.StorePageAdapter;
import com.leyline.salmoncookies.util.InjectorUtilities;
import com.leyline.salmoncookies.util.StoreModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StoreModel storeModel;
    private StoreModelFactory storeModelFactory;
    private List<Store> stores;
    RecyclerView rvStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeModelFactory = InjectorUtilities.instance.provideStoreModelFactory();
        storeModel = new ViewModelProvider(this, storeModelFactory).get(StoreModel.class);
        stores = storeModel.getStores().getValue();
        storeModel.initStores();
        storeModel.getStores().observe(this, stores -> {
            this.stores = stores;
            initUI();
        });

        bindUI();
    }
    private void bindUI(){

        rvStore = findViewById(R.id.rvStore);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToAdd();
            }
        });
        initUI();
    }

    private void initUI() {
        stores = storeModel.getStores().getValue();
        startViewPager();
    }
    private void intentToAdd(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
    private void startViewPager(){
        StorePageAdapter adapter = new StorePageAdapter(this.stores);
        rvStore.setAdapter(adapter);
        rvStore.setLayoutManager(new LinearLayoutManager(this));
    }
}
