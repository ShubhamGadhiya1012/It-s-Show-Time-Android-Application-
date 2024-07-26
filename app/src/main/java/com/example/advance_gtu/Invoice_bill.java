package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class Invoice_bill extends AppCompatActivity {

    public SQLiteDatabase db;
    ArrayAdapter<String> mp;
    Button gohome2;
    TextView name2,phone2,mname2,mtime2,cname2,seat2,price2,method2;
    String profile_id,profile_phone,profile_uname;
    My_Helper my_db;
    String name_m,time_m,cinema_m, seat_m,price_m,method_m,id_m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_bill);

        my_db = new My_Helper(this);

        id_m = getIntent().getStringExtra("idno");
        gohome2 = findViewById(R.id.gohome);

     name2 = findViewById(R.id.name);
     phone2 = findViewById(R.id.phone);
     mname2 = findViewById(R.id.mname);
     mtime2 = findViewById(R.id.mtime);
     cname2 = findViewById(R.id.cname);
     seat2 = findViewById(R.id.seat);
     price2 = findViewById(R.id.price);
     method2 = findViewById(R.id.method);


        Cursor c = my_db.getAllData(id_m);
        c.moveToFirst();
        while(! c.isAfterLast()){
            profile_id = c.getString(0);
            profile_phone = c.getString(3);
            profile_uname = c.getString(5);
            c.moveToNext();
        }
        c.close();



        Cursor c2 = my_db.getmovieinfo(id_m);
        c2.moveToFirst();
        while(! c2.isAfterLast()){

            name_m = c2.getString(1);
            time_m = c2.getString(2);
            cinema_m = c2.getString(4);
            seat_m = c2.getString(5);
            price_m = c2.getString(6);
            method_m = c2.getString(7);

            c2.moveToNext();
        }
        c2.close();




     name2.setText("Name: "+profile_uname);
     phone2.setText("Phone: "+profile_phone);
     mname2.setText("Movie: "+name_m);
     mtime2.setText("Time: "+time_m);
     cname2.setText(cinema_m);
     seat2.setText("Total Seat: "+seat_m);
     price2.setText("Amount: "+price_m);
     method2.setText("Payment: "+method_m);


        Intent igohome = new Intent(this,Home_fragment.class);
     gohome2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             igohome.putExtra("data_id",id_m);
             startActivity(igohome);
             finish();
         }
     });

    }
}