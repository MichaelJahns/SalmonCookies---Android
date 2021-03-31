package com.leyline.salmoncookies.store;

import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.leyline.salmoncookies.R;
import com.leyline.salmoncookies.views.StoreLocationText;

import java.util.ArrayList;
import java.util.List;

public class StorePageAdapter extends RecyclerView.Adapter<StorePageAdapter.StoreViewHolder> {
    private List<Store> storeList;
    private OnItemClickListener listener;


    public StorePageAdapter(){
        this.storeList = new ArrayList<Store>();
    }
    public StorePageAdapter(List<Store> storeList){
        this.storeList = storeList;
    }
    public void setStoreList(List<Store> stores){
        storeList = stores;
        notifyDataSetChanged();
    }
    public Store getStoreAt(int position){
         return storeList.get(position);
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
        Store store = this.storeList.get(position);
        holder.evLocation.setText(store.getLocation());
        holder.minCust.setText(String.valueOf(store.getMinCustomers()));
        holder.maxCust.setText(String.valueOf(store.getMaxCustomers()));
        holder.salesPerCust.setText(String.valueOf(store.getMinCustomers()));
        holder.evLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.storeList.size();
    }

    class StoreViewHolder extends RecyclerView.ViewHolder {
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(storeList.get(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Store store);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
