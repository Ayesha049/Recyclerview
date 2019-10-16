package com.ayeshaproject.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();



        for(int i=0;i<10;i++)
        {
            ArrayList<Model> arr = new ArrayList<Model>();
            for(int j=0;j<10;j++)
            {
                arr.add(new Model("ayesha" + j));
            }
            ListItem item = new ListItem("name","add",arr);
            listItems.add(item);
        }

        mAdapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(mAdapter);

    }
    // ...
}
