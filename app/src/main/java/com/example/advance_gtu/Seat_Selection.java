package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Seat_Selection extends AppCompatActivity {

    CheckBox r1c1, r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r2c1, r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,
            r3c1, r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r4c1, r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,
            r5c1, r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r6c1, r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,
            r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7;

    Button nextbutton;
    TextView amount_view,moviename,movietime;
    int count=0;

    String  m_name,m_time,m_cinema,m_id,dayname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);



        r1c1=findViewById(R.id.r1c1);
        r1c2=findViewById(R.id.r1c2);
        r1c3=findViewById(R.id.r1c3);
        r1c4=findViewById(R.id.r1c4);
        r1c5=findViewById(R.id.r1c5);
        r1c6=findViewById(R.id.r1c6);
        r1c7=findViewById(R.id.r1c7);
        r2c1=findViewById(R.id.r2c1);
        r2c2=findViewById(R.id.r2c2);
        r2c3=findViewById(R.id.r2c3);
        r2c4=findViewById(R.id.r2c4);
        r2c5=findViewById(R.id.r2c5);
        r2c6=findViewById(R.id.r2c6);
        r2c7=findViewById(R.id.r2c7);
        r1c1=findViewById(R.id.r2c7);
        r3c1=findViewById(R.id.r3c1);
        r3c2=findViewById(R.id.r3c2);
        r3c3=findViewById(R.id.r3c3);
        r3c4=findViewById(R.id.r3c4);
        r3c5=findViewById(R.id.r3c5);
        r3c6=findViewById(R.id.r3c6);
        r3c7=findViewById(R.id.r3c7);
        r4c1=findViewById(R.id.r4c1);
        r4c2=findViewById(R.id.r4c2);
        r4c3=findViewById(R.id.r4c3);
        r4c4=findViewById(R.id.r4c4);
        r4c5=findViewById(R.id.r4c5);
        r4c6=findViewById(R.id.r4c6);
        r4c7=findViewById(R.id.r4c7);
        r5c1=findViewById(R.id.r5c1);
        r5c2=findViewById(R.id.r5c2);
        r5c3=findViewById(R.id.r5c3);
        r5c4=findViewById(R.id.r5c4);
        r5c5=findViewById(R.id.r5c5);
        r5c6=findViewById(R.id.r5c6);
        r5c7=findViewById(R.id.r5c7);
        r6c1=findViewById(R.id.r6c1);
        r6c2=findViewById(R.id.r6c2);
        r6c3=findViewById(R.id.r6c3);
        r6c4=findViewById(R.id.r6c4);
        r6c5=findViewById(R.id.r6c5);
        r6c6=findViewById(R.id.r6c6);
        r6c7=findViewById(R.id.r6c7);
        r7c1=findViewById(R.id.r7c1);
        r7c2=findViewById(R.id.r7c2);
        r7c3=findViewById(R.id.r7c3);
        r7c4=findViewById(R.id.r7c4);
        r7c5=findViewById(R.id.r7c5);
        r7c6=findViewById(R.id.r7c6);
        r7c7=findViewById(R.id.r7c7);

        nextbutton = findViewById(R.id.Nextbtn);
        amount_view = findViewById(R.id.Amount_view);
        moviename = findViewById(R.id.Movie_name);
        movietime = findViewById(R.id.Movie_time);

        m_name = getIntent().getStringExtra("day_mname");
        m_time = getIntent().getStringExtra("day_mtime");
        m_cinema = getIntent().getStringExtra("day_cinema");
        m_id = getIntent().getStringExtra("day_id");
        dayname = getIntent().getStringExtra("name_day");


        moviename.setText("Movie Name : "+m_name);
        movietime.setText("Movie Time : "+m_time+","+dayname);


    }

    public void onSeatSelect(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        float ans;
        if (checked) {
            int selected = view.getId();

            count ++;

        }
        else {
            count --;
        }
        ans = count * 250;
        amount_view.setText("Seat Selected : "+count+" * 250₹ ="+ans+"₹");
        // Toast.makeText(this, "Seats Selected: " + count, Toast.LENGTH_SHORT).show();
        Intent nextpagepyment = new Intent(this,Payment_method.class);



            nextbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String count2 = String.valueOf(count);
                    String  ans2 = String.valueOf(ans);

                    if (count > 0) {
                        nextpagepyment.putExtra("mname",m_name);
                        nextpagepyment.putExtra("mtime",m_time);
                        nextpagepyment.putExtra("mcinema",m_cinema);
                        nextpagepyment.putExtra("mid",m_id);
                        nextpagepyment.putExtra("mday",dayname);
                        nextpagepyment.putExtra("mseat",count2);
                        nextpagepyment.putExtra("mprice",ans2);

                        startActivity(nextpagepyment);
                        finish();
                    } else {
                        Toast.makeText(Seat_Selection.this, "Opps!! Please Select The Minimum One Seat ", Toast.LENGTH_SHORT).show();
                    }
                }
            });






    }







}