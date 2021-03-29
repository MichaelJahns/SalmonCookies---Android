package com.leyline.salmoncookies.store;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "store_table")
public class Store {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "store_id")
    private int id;
    @ColumnInfo(name="store_location")
    private String location;
    @ColumnInfo(name = "store_average_sales")
    private Float averageSales;
    @ColumnInfo(name = "store_min_customers")
    private int minCustomers;
//    By default the table row is the same as the variable, snake case is the correct annotation for sql lite
//    @ColumnInfo(name = "store_max_customers")
    private int maxCustomers;

    public Store(String location, float averageSales, int minCustomers, int maxCustomers) {
        this.location = location;
        this.averageSales = averageSales;
        this.minCustomers = minCustomers;
        this.maxCustomers = maxCustomers;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getLocation() {
        return location;
    }
    public Float getAverageSales() {
        return averageSales;
    }
    public int getMinCustomers() {
        return minCustomers;
    }
    public int getMaxCustomers() {
        return maxCustomers;
    }

}
