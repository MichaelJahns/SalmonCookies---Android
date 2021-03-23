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

public class StorePageAdapter extends RecyclerView.Adapter<StorePageAdapter.ViewPager2Holder> {
    private List<Store> stores;
    public StorePageAdapter(List<Store> stores){
        this.stores = stores;
    }
    @NonNull
    @Override
    public ViewPager2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_row, parent, false);
        return new ViewPager2Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPager2Holder holder, int position) {
        Store store = this.stores.get(position);
        holder.evLocation.setText(store.getLocation());
        holder.minCust.setText(store.getMinCustomers());
        holder.maxCust.setText(store.getMaxCustomers());
        holder.salesPerCust.setText(store.getAverageSales().toString());

    }

    @Override
    public int getItemCount() {
        return this.stores.size();
    }

    public static class ViewPager2Holder extends RecyclerView.ViewHolder {
        private StoreLocationText evLocation;
        private TextView minCust;
        private TextView maxCust;
        private TextView salesPerCust;

        public ViewPager2Holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
