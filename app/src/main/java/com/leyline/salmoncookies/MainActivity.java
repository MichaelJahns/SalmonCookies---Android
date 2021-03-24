package com.leyline.salmoncookies;

import android.content.Intent;
import android.graphics.HardwareRenderer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreFactory;
import com.leyline.salmoncookies.store.StoreModel;
import com.leyline.salmoncookies.store.StorePageAdapter;
import com.leyline.salmoncookies.util.InjectorUtilities;
import com.leyline.salmoncookies.util.StoreModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StoreModelFactory storeModelFactory;
    private StoreModel storeModel;
    private StoreListFragment storeListFragment;
    RecyclerView rvStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeListFragment = new StoreListFragment();
        storeModelFactory = InjectorUtilities.instance.provideStoreModelFactory();
        storeModel.initStores();

        bindUI();
        initUI();
    }
    private void initUI(){
        storeModel = new ViewModelProvider(this, storeModelFactory).get(StoreModel.class);
        setCurrentFragment(storeListFragment);
    }
    private void bindUI(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToAdd();
            }
        });
    }

    private void intentToAdd(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private FragmentTransaction setCurrentFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayout, fragment);
        transaction.commit();
        return transaction;
    }
}
