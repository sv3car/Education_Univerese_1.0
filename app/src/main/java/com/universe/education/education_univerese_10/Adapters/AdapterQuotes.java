package com.universe.education.education_univerese_10.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universe.education.education_univerese_10.Classes.Quote;
import com.universe.education.education_univerese_10.R;

import java.util.List;


public class AdapterQuotes extends RecyclerView.Adapter<AdapterQuotes._ViewHolder> implements View.OnClickListener{

    private List<Quote> items;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    public static class _ViewHolder extends RecyclerView.ViewHolder {

        // Campos respectivos de un item
        public TextView asunto;
        public TextView total;

        public _ViewHolder(View v) {
            super(v);
            asunto = (TextView) v.findViewById(R.id.tvAsunto);
            total = (TextView) v.findViewById(R.id.tvTotal);
        }
    }

    public AdapterQuotes(List<Quote> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public _ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_quotes, viewGroup, false);
        v.setOnClickListener(this);
        return new _ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(_ViewHolder viewHolder, int i) {
        viewHolder.asunto.setText(items.get(i).getAsunto());
        viewHolder.total.setText(items.get(i).getTotalGen()+"AUD");
    }
}
