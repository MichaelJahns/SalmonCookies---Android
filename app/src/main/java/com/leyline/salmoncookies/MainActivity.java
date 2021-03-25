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
    private StoreModel storeModel;
    private StoreListFragment storeListFragment;
    private AddFragment addFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeModel = new ViewModelProvider(this).get(StoreModel.class);
        storeModel.getStores();
        storeModel.getStores().observe(this, stores -> {
            intentToList();
        });
        storeListFragment = new StoreListFragment();
        addFragment = new AddFragment();
        bindUI();
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
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToList();
            }
        });
    }

    public void intentToAdd(){
        setCurrentFragment(addFragment);
    }
    public void intentToList(){
        setCurrentFragment(storeListFragment);
    }

    private FragmentTransaction setCurrentFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayout, fragment);
        transaction.commit();
        return transaction;
    }
}
