package com.example.advance_gtu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home_fragment extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Movies_Home mh =new Movies_Home();
    Upcoming_Home uh = new Upcoming_Home();
    Profile_Home ph = new Profile_Home();
    public static String homepage_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fragment);

        homepage_id = getIntent().getStringExtra("data_id");
        Bundle bundle = new Bundle();

        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        bundle.putString("idKey",homepage_id);
        mh.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,mh).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()) {

                    case R.id.home:

                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, mh).commit();
                        return true;

                    case R.id.upcoming:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, uh).commit();
                        return true;

                    case R.id.profile:

                        bundle.putString("idKey",homepage_id);
                        ph.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, ph).commit();
                        return true;

                }
                return false;
            }
        });






    }

    //---------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int name = item.getItemId();
        if(name==R.id.his){

          //  Toast.makeText(this, homepage_id, Toast.LENGTH_SHORT).show();
            Intent inhistory = new Intent(this,History_Movie.class);
            inhistory.putExtra("history",homepage_id);
            startActivity(inhistory);
            //finish();

        }
        else if(name==R.id.log){

            Intent inlogout = new Intent(this,MainActivity.class);
            startActivity(inlogout);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }


    //-------------------------------------------------------------------


}