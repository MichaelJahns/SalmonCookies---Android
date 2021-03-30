package com.leyline.salmoncookies;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    private StoreListFragment storeListFragment;
    private AddFragment addFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
