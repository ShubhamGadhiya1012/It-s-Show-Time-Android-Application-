package com.example.advance_gtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter_2 extends BaseAdapter {


    Context context;
    int[] poster_upcoming;
    LayoutInflater inflater;

    public CustomAdapter_2(Context context, int[] poster_upcoming) {
        this.context = context;
        this.poster_upcoming = poster_upcoming;
    }

    @Override
    public int getCount() {
        return poster_upcoming.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater==null){
            inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if(view==null){
            view=inflater.inflate(R.layout.grid_item_2,null);
        }
        ImageView imageview = view.findViewById(R.id.grid_upcoming);

        imageview.setImageResource(poster_upcoming[i]);

        return view;
    }


}
