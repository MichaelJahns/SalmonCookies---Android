package com.leyline.salmoncookies.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leyline.salmoncookies.R;
import com.leyline.salmoncookies.views.StoreLocationText;

import java.util.List;

public class StorePageAdapter extends RecyclerView.Adapter<StorePageAdapter.StoreViewHolder> {
    private List<Store> stores;
    public StorePageAdapter(List<Store> stores){
        this.stores = stores;
    }
    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.store_row, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        Store store = this.stores.get(position);
        holder.evLocation.setText(store.getLocation());
        holder.minCust.setText(String.valueOf(store.getMinCustomers()));
        holder.maxCust.setText(String.valueOf(store.getMaxCustomers()));
        holder.salesPerCust.setText(String.valueOf(store.getMinCustomers()));
    }

    @Override
    public int getItemCount() {
        return this.stores.size();
    }

    public static class StoreViewHolder extends RecyclerView.ViewHolder {
        private StoreLocationText evLocation;
        private TextView minCust;
        private TextView maxCust;
        private TextView salesPerCust;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            evLocation = itemView.findViewById(R.id.evStoreLocation);
            minCust = itemView.findViewById(R.id.evStoreMinCust);
            maxCust = itemView.findViewById(R.id.evStoreMaxCust);
            salesPerCust = itemView.findViewById(R.id.evStoreSalePerCust);
        }
    }
}
