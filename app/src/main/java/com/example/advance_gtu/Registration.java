package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    public SQLiteDatabase db;
    ArrayAdapter<String> mp;
    ContentValues cv;
    EditText fn,ln,pn,em,un,pw,cpw;
    String num;
    private String id_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

         fn =  findViewById(R.id.firstname);
         ln =  findViewById(R.id.lastname);
         pn =  findViewById(R.id.phonenumber);
         em =  findViewById(R.id.emailid);
         un =  findViewById(R.id.usrname_singup);
         pw =  findViewById(R.id.password_signup);
         cpw = findViewById(R.id.conpassword_signup);
        Button sinup_btn = (Button)findViewById(R.id.signup_done);

        Intent singup_intent = new Intent(this,Home_fragment.class);


        try{

           db = openOrCreateDatabase("Gtu_Movie",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            db.execSQL("Create Table Profile(id varchar PRIMARY KEY AUTOINCREMENT,f_name text,l_name text,p_number text,email text,u_name text,password text)");
        }
        catch(SQLException e){
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        sinup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass1 = pw.getText().toString();
                String pass2 = cpw.getText().toString();
                 num = pn.getText().toString();

                if ( !pass1.equals("")) {

                    if (pass1.equals(pass2)) {

//                        db.delete("Profile",null,null);
//                        db.close();

                        ContentValues cv = new ContentValues();
                        cv.put("f_name", fn.getText().toString());
                        cv.put("l_name", ln.getText().toString());
                        cv.put("p_number", pn.getText().toString());
                        cv.put("email", em.getText().toString());
                        cv.put("u_name", un.getText().toString());
                        cv.put("password", pw.getText().toString());

                        //  Toast.makeText(Registration.this, "Singup Completeed", Toast.LENGTH_SHORT).show();

                        if ((db.insert("Profile", null, cv)) != -1) {


                            // Send the id to main home page using intent

                            Cursor c = db.rawQuery("SELECT * FROM Profile ",null);

                            c.moveToFirst();
                            while(! c.isAfterLast()){
                                if(c.getString(3).equals(num)) {
                                 //   Toast.makeText(Registration.this, c.getString(0), Toast.LENGTH_SHORT).show();
                                    id_data = c.getString(0);

                                }
                                c.moveToNext();
                            }
                            c.close();




                       //     Toast.makeText(Registration.this, "Registration Successfully", Toast.LENGTH_SHORT).show();

                          //  idPassData(id_data);
                            singup_intent.putExtra("data_id",id_data);
                            startActivity(singup_intent);

                        } else {
                            Toast.makeText(Registration.this, "Not Done", Toast.LENGTH_SHORT).show();
                        }


                    } else {

                        Toast.makeText(Registration.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                    }
                }

                else{
                    Toast.makeText(Registration.this, "Please Enter The Information", Toast.LENGTH_SHORT).show();
                }
            }






        });
    }








}