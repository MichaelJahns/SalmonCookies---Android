package com.leyline.salmoncookies.store;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Stores")
public class Store {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "storeId")
    private int id;
    @ColumnInfo(name="storeLocation")
    private String location;
    private Float averageSales;
    private int minCustomers;
    private int maxCustomers;

    public Store(){
        this.location = "Seattle";
        this.averageSales = 6.65f;
        this.minCustomers = 23;
        this.maxCustomers = 39;
    }
    public Store(String location, float averageSales, int minCustomers, int maxCustomers) {
        this.location = location;
        this.averageSales = averageSales;
        this.minCustomers = minCustomers;
        this.maxCustomers = maxCustomers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getAverageSales() {
        return averageSales;
    }

    public void setAverageSales(Float averageSales) {
        this.averageSales = averageSales;
    }

    public int getMinCustomers() {
        return minCustomers;
    }

    public void setMinCustomers(int minCustomers) {
        this.minCustomers = minCustomers;
    }

    public int getMaxCustomers() {
        return maxCustomers;
    }

    public void setMaxCustomers(int maxCustomers) {
        this.maxCustomers = maxCustomers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
