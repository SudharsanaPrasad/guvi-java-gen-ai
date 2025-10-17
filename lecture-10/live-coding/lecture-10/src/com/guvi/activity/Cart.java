package com.guvi.activity;

import java.util.ArrayList;
import java.util.List;

public class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void add(T t){
        items.add(t);
    }

    public T first(){
        if(items.isEmpty()) {
            return null;
        }
        return items.get(0);
    }

}
