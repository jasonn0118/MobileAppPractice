package com.example.cityguideapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyCustomerAdaptor extends BaseAdapter {
    List<String> adapterList;
    List<Integer> adapterPics;
    Context context;

    public MyCustomerAdaptor(List<String> adapterList, List<Integer> adapterPics, Context context) {
        this.adapterList = adapterList;
        this.adapterPics = adapterPics;
        this.context = context;
    }

    @Override
    public int getCount() {
        return adapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater myLayoutInflater = LayoutInflater.from(parent.getContext());
            convertView = myLayoutInflater.inflate(R.layout.layout_item, parent, false);
        }
        TextView txtViewItem = convertView.findViewById(R.id.txtViewItem);
        txtViewItem.setText(adapterList.get(position));
        Drawable img = parent.getResources().getDrawable(adapterPics.get(position));
        img.setBounds(0,0,80,80);
        txtViewItem.setCompoundDrawables(img,null,null,null);
        txtViewItem.setCompoundDrawablePadding(16);
        return convertView;
    }
}
