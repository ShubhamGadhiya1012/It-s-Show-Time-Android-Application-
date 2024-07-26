package com.example.advance_gtu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_Profile extends AppCompatActivity {

    public SQLiteDatabase db;
    My_Helper my_dh;
    public String edit_fname,edit_lname,edit_uname,edit_email,edit_phone;
    EditText e_fname,e_lname,e_uname,e_phone,e_email;
    Button update_btn;
    Profile_Home ph = new Profile_Home();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent backhome = new Intent(this,Profile_Home.class);

        try{

            db = openOrCreateDatabase("Gtu_Movie",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        }
        catch(SQLException e){
//            Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
        }

        e_fname = findViewById(R.id.editfname);
        e_lname = findViewById(R.id.editlname);
        e_uname = findViewById(R.id.edituname);
        e_email = findViewById(R.id.editemail);
        e_phone = findViewById(R.id.editphone);
        update_btn = findViewById(R.id.btn_update);
        String edit_id = getIntent().getStringExtra("editid");


        my_dh = new My_Helper(this);
        Cursor c = my_dh.getAllData(edit_id);

        c.moveToFirst();
        while(! c.isAfterLast()){
          //  profile_id = c.getString(0);
            edit_fname = c.getString(1);
            edit_lname = c.getString(2);
            edit_phone = c.getString(3);
            edit_email = c.getString(4);
            edit_uname = c.getString(5);
            c.moveToNext();
        }
        c.close();

        e_fname.setText(edit_fname);
        e_lname.setText(edit_lname);
        e_uname.setText(edit_uname);
        e_email.setText(edit_email);
        e_phone.setText(edit_phone);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String up_fname = e_fname.getText().toString();
                String up_lname = e_lname.getText().toString();
                String up_uname = e_uname.getText().toString();
                String up_email = e_email.getText().toString();
                String up_phone = e_phone.getText().toString();


                ContentValues cv =  new  ContentValues();

                cv.put("f_name",up_fname);
                cv.put("l_name",up_lname);
                cv.put("u_name",up_uname);
                cv.put("email",up_email);
                cv.put("p_number",up_phone);
                db.execSQL(" update Profile set f_name='"+up_fname+"',l_name='"+up_lname+"',p_number='"+up_phone+"',email='"+up_email+"',u_name='"+up_uname+"' where id='"+edit_id+"' ");
                startActivity(backhome);


//                Toast.makeText(Edit_Profile.this, "Done", Toast.LENGTH_SHORT).show();



            }
        });

    }
}