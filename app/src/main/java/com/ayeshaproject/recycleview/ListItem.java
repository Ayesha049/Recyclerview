package com.ayeshaproject.recycleview;

import java.util.ArrayList;

public class ListItem {
    public String name;
    public String add;
    public ArrayList<Model> arr;


    public ListItem(String name, String add, ArrayList<Model> arr) {
        this.name = name;
        this.add = add;
        this.arr = arr;
    }
}
