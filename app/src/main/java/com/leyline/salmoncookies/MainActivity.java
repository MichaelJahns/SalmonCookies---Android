package com.leyline.salmoncookies;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreFactory;
import com.leyline.salmoncookies.store.StoreModel;
import com.leyline.salmoncookies.store.StorePageAdapter;
import com.leyline.salmoncookies.util.InjectorUtilities;
import com.leyline.salmoncookies.util.StoreModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;

import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    private StoreModel storeModel;
    private final StoreModelFactory storeModelFactory = InjectorUtilities.instance.provideStoreModelFactory();
    private ViewPager2 storeViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        storeViewPager = findViewById(R.id.rvStoreViewPager);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initUI();
            }
        });
    }

    private void initUI() {
        storeModel = new ViewModelProvider(this).get(StoreModel.class);
        storeModel.getStores().observe(this, stores -> startViewPager(stores));
    }
    private void startViewPager(List<Store> storeList){
        this.storeViewPager.setAdapter(new StorePageAdapter(storeList));
        this.storeViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }
}
