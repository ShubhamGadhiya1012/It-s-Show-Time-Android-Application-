package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Upcoming_Description extends AppCompatActivity {

    ImageView uiv1;
    String trailer[] = {"https://www.youtube.com/watch?v=V5jVntRVl-0","https://www.youtube.com/watch?v=_Z3QKkl1WyM",
            "https://www.youtube.com/watch?v=hpwnlr-ZHB0", "https://www.youtube.com/watch?v=mfl--nI-Bhs",
            "https://www.youtube.com/watch?v=x-sgnhYJGOA", "https://www.youtube.com/watch?v=VgGgYOzNWno",
            "https://www.youtube.com/watch?v=X0tOpBuYasI","https://www.youtube.com/watch?v=1d0Zf9sXlHk",
            "https://www.youtube.com/watch?v=cxA2y9Tgl7o","https://www.youtube.com/watch?v=a53e4HHnx_s"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_description);


        uiv1  = (ImageView) findViewById(R.id.upcoming_poster);
        TextView utv1 = (TextView) findViewById(R.id.upcoming_name);
        TextView utv2 = (TextView) findViewById(R.id.upcoming_discription);
        int pos;


        Intent intent = getIntent();
        pos = intent.getIntExtra("imgPos", 0);
        utv1.setText(intent.getStringExtra("movie_name"));
        utv2.setText(intent.getStringExtra("discription"));
        uiv1.setImageResource(intent.getIntExtra("image", 0));

        uiv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl(pos);
            }
        });


    }
    private void gotoUrl(int pos) {
        String t_url = trailer[pos];
        Uri uri = Uri.parse(t_url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}