package com.example.fragmenttask;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private List<Pair<String, Boolean>> list;

    public ItemAdapter(List<Pair<String, Boolean>> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).first);
        holder.checkBox.setChecked(list.get(position).second);
        

        holder.checkBox.setOnCheckedChangeListener(null);

        holder.checkBox.setOnCheckedChangeListener((compoundButton, checked) -> {
            Pair<String, Boolean> pair = list.get(position);
            list.set(position, new Pair<>(pair.first, checked));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItemToList(String itemName) {
        list.add(new Pair<>(itemName, false));
        notifyDataSetChanged();
    }

    public void deleteItems() {
        for(int i=list.size()-1;i>=0;--i) {
           if(list.get(i).second) {
               list.remove(i);
               notifyItemRemoved(i);
               notifyItemRangeChanged(i, getItemCount()-i);
           }
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkbox);
        }

    }
}
