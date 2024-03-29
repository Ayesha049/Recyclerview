package com.ayeshaproject.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItem, Context context) {
        this.listItems = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.name.setText(item.name);
        holder.add.setText(item.add);

        ArrayList<Model> list_inner = item.arr;

        holder.recycle.setHasFixedSize(true);
        holder.recycle.setLayoutManager(new LinearLayoutManager(context));

        RecyclerView.Adapter adapter = new InnerAdapter(list_inner,context);

        holder.recycle.setAdapter(adapter);

        adapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView add;
        public RecyclerView recycle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            add = itemView.findViewById(R.id.add);
            recycle = itemView.findViewById(R.id.inner_recycler);
        }
    }
}
