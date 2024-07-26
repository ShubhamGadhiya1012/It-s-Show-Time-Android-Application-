package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            db = openOrCreateDatabase("Gtu_Movie",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        }
        catch(SQLException e){
//            Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
        }


        Intent i1 = new Intent(this,Registration.class);
        Intent home_frag = new Intent(this,Home_fragment.class);
        Button su = (Button) findViewById(R.id.signupbtn);

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(i1);

            }
        });

        //--------------------------------- Login Validation---------------------


        Button lo = (Button) findViewById(R.id.loginbtn);
        EditText user = (EditText)findViewById(R.id.username);
        EditText pass = (EditText)findViewById(R.id.password);



        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getuser = user.getText().toString();
                String getpass = pass.getText().toString();
                String getnumber = "";
                String getpassword = "";
                String id_data ="";

                Cursor c = db.rawQuery("SELECT * FROM Profile ",null);

                c.moveToFirst();
                while(! c.isAfterLast()){
                    if(c.getString(3).equals(getuser) && c.getString(6).equals(getpass)) {
                        //   Toast.makeText(Registration.this, c.getString(0), Toast.LENGTH_SHORT).show();
                         id_data = c.getString(0);
                         getnumber = c.getString(3);
                         getpassword = c.getString(6);

                    }
                    c.moveToNext();

                }
                c.close();

                if(!getpass.equals("") && !getuser.equals("")) {

                    if (getpassword.equals(getpass) && getnumber.equals(getuser)) {
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        home_frag.putExtra("data_id", id_data);
                        startActivity(home_frag);

                    } else {
                        Toast.makeText(MainActivity.this, "Password Not Matched ", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Enter User/Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}