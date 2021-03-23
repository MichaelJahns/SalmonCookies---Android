package com.leyline.salmoncookies;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.leyline.salmoncookies.store.Store;
import com.leyline.salmoncookies.store.StoreModel;
import com.leyline.salmoncookies.util.InjectorUtilities;
import com.leyline.salmoncookies.util.StoreModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private StoreModel storeModel;
    private StoreModelFactory storeModelFactory;
    EditText etStoreLocation, etStoreAverageSales, etStoreMinCust, etStoreMaxCust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        storeModelFactory = InjectorUtilities.instance.provideStoreModelFactory();
        storeModel = new ViewModelProvider(this, storeModelFactory).get(StoreModel.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Store userStore = getUserStore(view);
            storeModel.addStore(userStore);
            intentToMain();
            }
        });
        bindUI();
    }

    private void bindUI(){
        this.etStoreLocation = findViewById(R.id.etStoreLocation);
        this.etStoreAverageSales = findViewById(R.id.etStoreAverageSales);
        this.etStoreMinCust = findViewById(R.id.etStoreMinCust);
        this.etStoreMaxCust = findViewById(R.id.etStoreMaxCust);
    }


    public Store getUserStore(View view) {
        String location = etStoreLocation.getText().toString();
        Float averageSales = Float.parseFloat(etStoreAverageSales.getText().toString());
        int minCust = Integer.parseInt(etStoreMinCust.getText().toString());
        int maxCust = Integer.parseInt(etStoreMaxCust.getText().toString());
        Store userStore = new Store(location, averageSales, minCust, maxCust);
        return userStore;
    }
    public void intentToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}