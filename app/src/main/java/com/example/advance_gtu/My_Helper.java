package com.example.advance_gtu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class My_Helper extends SQLiteOpenHelper {



    public static  final String DATABASE_NAME = "Gtu_Movie";


    public My_Helper(Context c){

        super(c,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getAllData(String profile_id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from Profile where id="+profile_id,null);
        return data;

    }

    public void deleteuser(String id){

        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from Profile where id="+id);
        db.close();

    }

    public Cursor getmovieinfo(String profile_id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data2 = db.rawQuery("select * from Movie_info where id="+profile_id,null);
        return data2;

    }


}

