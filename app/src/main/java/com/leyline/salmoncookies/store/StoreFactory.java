package com.leyline.salmoncookies.store;

import java.util.ArrayList;
import java.util.List;

public final class StoreFactory {
    public static final StoreFactory INSTANCE;

    static {
        INSTANCE = new StoreFactory();
    }

    public List<Store> getStores() {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("Sequim", 10.4f, 3, 17));
        stores.add(new Store("Port Angeles", 12.5f, 7, 15));
        stores.add(new Store("Forks", 3.5f, 3, 9));
        stores.add(new Store("Jamestown", 22.2f, 15, 23));
        return stores;
    }
}
