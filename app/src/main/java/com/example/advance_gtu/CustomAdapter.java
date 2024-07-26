package com.example.advance_gtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] moviesname;
    int[] poster;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] moviesname, int[] poster) {
        this.context = context;
        this.moviesname = moviesname;
        this.poster = poster;
    }

    @Override
    public int getCount() {
        return moviesname.length;
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
            view=inflater.inflate(R.layout.grid_item,null);
        }
        ImageView imageview = view.findViewById(R.id.grid_image);
        TextView textview = view.findViewById(R.id.item_name);

        imageview.setImageResource(poster[i]);
        textview.setText(moviesname[i]);

        return view;
    }
}
