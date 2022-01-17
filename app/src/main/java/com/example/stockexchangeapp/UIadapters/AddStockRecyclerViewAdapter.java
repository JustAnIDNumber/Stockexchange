package com.example.stockexchangeapp.UIadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockexchangeapp.R;
import com.example.stockexchangeapp.StockAPIs.TickerSearch;

public class AddStockRecyclerViewAdapter extends RecyclerView.Adapter<AddStockRecyclerViewAdapter.StockViewHolder> {

    TickerSearch tickerList;

    public void AddStickRecyclerViewAdaptor(TickerSearch tickerSearchResults){
        this.tickerList = tickerSearchResults;
    }

    public class StockViewHolder extends RecyclerView.ViewHolder{

        private TextView ticker;
        private TextView name;
        private TextView type;

        public StockViewHolder(final View itemView) {
            super(itemView);

            this.ticker = itemView.findViewById(R.id.a_stock_ticker);                               //Apparently viewbinding is useless for recyclerviews so findviewbyid is used
            this.name   = itemView.findViewById(R.id.a_stock_name);
            this.type  = itemView.findViewById(R.id.a_stock_type);

        }
    }
    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_a_stock, parent, false);
            return new StockViewHolder((itemview));
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        holder.name.setText(tickerList.getResultAtPosition(position).getSymbol());
        holder.ticker.setText(tickerList.getResultAtPosition(position).getDisplaySymbol());
        holder.type.setText(tickerList.getResultAtPosition(position).getType());
    }

    @Override
    public int getItemCount() {
        return tickerList.getResultCount();
    }
}
