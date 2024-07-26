package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class History_Movie extends AppCompatActivity {
    My_Helper my_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_movie);

        ArrayList<String> arrayList = new ArrayList<String>();
        ListView v1 = (ListView) findViewById(R.id.listview1);

        String historyid = getIntent().getStringExtra("history").toString();



        my_db = new My_Helper(this);


        Cursor c2 = my_db.getmovieinfo(historyid);
        c2.moveToFirst();
        while(! c2.isAfterLast()){

            arrayList.add("Movie: "+c2.getString(1)+"\nTime: "+c2.getString(2)+"\nDay: "+c2.getString(3)+"\nCinema: "+c2.getString(4)+"\nSeat: "+c2.getString(5)+"\nTotal Amount: "+c2.getString(6));
//            time_m = c2.getString(2);
//            cinema_m = c2.getString(3);
//            seat_m = c2.getString(4);
//            price_m = c2.getString(5);
//            method_m = c2.getString(6);

            c2.moveToNext();
        }
        c2.close();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.history_view, arrayList);


        v1.setAdapter(adapter);

    }
}