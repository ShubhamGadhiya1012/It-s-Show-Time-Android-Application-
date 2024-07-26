package com.example.advance_gtu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Payment_method extends AppCompatActivity {

    public SQLiteDatabase db;
    ArrayAdapter<String> mp;
    NotificationManager notificationManager;

    RadioGroup rg;
    Button confirm;
    RadioButton rb;
    TextView view1,view2,view3,view4,view5;

    String name_m,time_m,cinema_m, seat_m,price_m,id_m,day_m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        view1 = findViewById(R.id.m_info);
        view2 = findViewById(R.id.m_info2);
        view3 = findViewById(R.id.m_info3);
        view4 = findViewById(R.id.m_info4);
        view5 = findViewById(R.id.m_info5);

        name_m = getIntent().getStringExtra("mname");
        time_m = getIntent().getStringExtra("mtime");
        cinema_m = getIntent().getStringExtra("mcinema");
        seat_m = getIntent().getStringExtra("mseat");
        price_m = getIntent().getStringExtra("mprice");
        id_m = getIntent().getStringExtra("mid");
        day_m = getIntent().getStringExtra("mday");

        view1.setText(name_m);
        view2.setText("Time : "+time_m+","+day_m);
        view3.setText(cinema_m);
        view4.setText("Total Seat : "+seat_m);
        view5.setText("Total Amount : "+price_m+"₹");

        Intent goinvoice = new Intent(this,Invoice_bill.class);

        try{

            db = openOrCreateDatabase("Gtu_Movie", SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("Create Table Movie_info(id varchar,movie_name text,movie_time text,day_name text,cinema text,seat_no text,amount text,pyment_method text)");
//            db.execSQL("DROP TABLE Movie_info");

        }
        catch(SQLException e){
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        confirm = findViewById(R.id.confirmbtn);
        rg = findViewById(R.id.radiogroup);
        int value =rg.getCheckedRadioButtonId();
        rb = (RadioButton)findViewById(value);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                        db.delete("Movie_info",null,null);
//                        db.close();

                    int value = rg.getCheckedRadioButtonId();
                    rb = (RadioButton) findViewById(value);
                    String method = rb.getText().toString();
//                Toast.makeText(Payment_method.this,rb_text, Toast.LENGTH_SHORT).show();


                    ContentValues cv = new ContentValues();
                    cv.put("id", id_m);
                    cv.put("movie_name", name_m);
                    cv.put("movie_time", time_m);
                    cv.put("cinema", cinema_m);
                    cv.put("seat_no", seat_m);
                    cv.put("amount", price_m + "₹");
                    cv.put("day_name", day_m);
                    cv.put("pyment_method", method);


                    if ((db.insert("Movie_info", null, cv)) != -1) {

//                    Toast.makeText(Payment_method.this, "Insert Done", Toast.LENGTH_SHORT).show();
                    } else {
//                    Toast.makeText(Payment_method.this, "Not Insert", Toast.LENGTH_SHORT).show();
                    }

                    AlertDialog.Builder bulider = new AlertDialog.Builder(Payment_method.this);
                    LayoutInflater inflater = getLayoutInflater();
                    bulider.setView(inflater.inflate(R.layout.loading_dialog, null));
                    bulider.setCancelable(false);
                    AlertDialog dialog = bulider.create();
                    dialog.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();

//
                            goinvoice.putExtra("idno", id_m);
                            startActivity(goinvoice);
                            finish();
                        }
                    }, 3500);


                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("My Notification","My Notification App",NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager=getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);

                }

                Intent i = new Intent(Payment_method.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(Payment_method.this,0,i,PendingIntent.FLAG_IMMUTABLE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Payment_method.this,"My Notification")
                        .setSmallIcon(R.drawable.logopngs)
                        .setContentTitle("Ticket Booking Completed.")
                        .setContentText("Your Movie Ticket Booking Completed,You checked ticket in history ticket. ")
                        .setAutoCancel(true)

                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logopngs))
                        .setContentIntent(pendingIntent);
                NotificationManagerCompat nm = NotificationManagerCompat.from(Payment_method.this);
                nm.notify(1,builder.build());

            }
        });

    }
}