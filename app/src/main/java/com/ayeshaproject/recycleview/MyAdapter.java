package com.ayeshaproject.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.name.setText(item.name);
        holder.add.setText(item.add);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"hello",Toast.LENGTH_LONG).show();
                TextView textView = new TextView(context);
                textView.setText("I am added dynamically to the view");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
                textView.setLayoutParams(params);
                holder.lnr.addView(textView);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView add;
        public Button btn;
        public LinearLayout lnr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            add = itemView.findViewById(R.id.add);
            btn = itemView.findViewById(R.id.btn);
            lnr = itemView.findViewById(R.id.linear);
        }
    }
}
