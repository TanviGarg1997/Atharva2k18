package com.example.tanvi.atharva2k18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class CardAdapter extends ArrayAdapter<Integer> {
    public CardAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imgView=(ImageView)convertView.findViewById(R.id.image);
        imgView.setImageResource(getItem(position));
        return convertView;
    }
}
