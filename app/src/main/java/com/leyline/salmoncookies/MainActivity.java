package com.leyline.salmoncookies;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreViewModel;
import com.leyline.salmoncookies.util.StoreViewModelFactory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StoreViewModelFactory factory;
    private StoreViewModel storeViewModel;
    private StoreListFragment storeListFragment;
    private AddFragment addFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        factory = new StoreViewModelFactory(getApplication());
        storeViewModel = new ViewModelProvider(this, factory).get(StoreViewModel.class);
        storeListFragment = new StoreListFragment();
        addFragment = new AddFragment();
        bindUI();
        observerSetup();
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

    private void observerSetup() {
        factory = new StoreViewModelFactory(getApplication());
        storeViewModel = new ViewModelProvider(this, factory).get(StoreViewModel.class);
        storeViewModel.getAllStores().observe(this, new Observer<List<Store>>() {
            @Override
            public void onChanged(List<Store> stores) {
                setCurrentFragment(storeListFragment);
            }
        });
    }

}
