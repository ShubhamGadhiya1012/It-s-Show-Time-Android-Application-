package com.example.advance_gtu.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.advance_gtu.R;
import com.example.advance_gtu.Seat_Selection;


public class Saturday extends Fragment {

    // TODO: Rename parameter arguments, choose names that match


    public Saturday() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saturday, container, false);

        Button b1 =(Button) view.findViewById(R.id.selet_seat0);
        Button b2 =(Button) view.findViewById(R.id.selet_seat1);
        Button b3 =(Button) view.findViewById(R.id.selet_seat2);
        Button b4 =(Button) view.findViewById(R.id.selet_seat3);
        Button b5 =(Button) view.findViewById(R.id.selet_seat4);
        Button b6 =(Button) view.findViewById(R.id.selet_seat5);
        Button b7 =(Button) view.findViewById(R.id.selet_seat6);
        Button b8 =(Button) view.findViewById(R.id.selet_seat7);
        Button b9 =(Button) view.findViewById(R.id.selet_seat8);
        Button b10 =(Button) view.findViewById(R.id.selet_seat9);
        Button b11 =(Button) view.findViewById(R.id.selet_seat10);
        Button b12 =(Button) view.findViewById(R.id.selet_seat11);
        Button b13 =(Button) view.findViewById(R.id.selet_seat12);
        Button b14 =(Button) view.findViewById(R.id.selet_seat13);
        Button b15 =(Button) view.findViewById(R.id.selet_seat14);
        Button b16 =(Button) view.findViewById(R.id.selet_seat15);
        Button b17 =(Button) view.findViewById(R.id.selet_seat16);
        Button b18 =(Button) view.findViewById(R.id.selet_seat17);
        Button b19 =(Button) view.findViewById(R.id.selet_seat18);
        Button b20 =(Button) view.findViewById(R.id.selet_seat19);
        Button b21 =(Button) view.findViewById(R.id.selet_seat20);

        TextView tt = (TextView)view.findViewById(R.id.nameview);
        String mname = getActivity().getIntent().getStringExtra("mname");
        String id_tab = getActivity().getIntent().getStringExtra("id_mhome");

        //  tt.setText(mname);

        String cinema1 = "19 Cinema South Bopal, Ahemdabad";
        String cinema2 = "PVR: Acropolis, Ahmedabad";
        String cinema3 = "AB Miniplex Shrivranjini Cross Road,Satellite";
        String cinema4 = "Connplex Smart Theatre, Prahladnagar";
        String dayname = "Saturday";


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b1.getText().toString());
                i.putExtra("day_cinema",cinema1);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b2.getText().toString());
                i.putExtra("day_cinema",cinema1);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b3.getText().toString());
                i.putExtra("day_cinema",cinema1);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b4.getText().toString());
                i.putExtra("day_cinema",cinema1);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b5.getText().toString());
                i.putExtra("day_cinema",cinema1);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b6.getText().toString());
                i.putExtra("day_cinema",cinema2);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b7.getText().toString());
                i.putExtra("day_cinema",cinema2);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b8.getText().toString());
                i.putExtra("day_cinema",cinema2);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b9.getText().toString());
                i.putExtra("day_cinema",cinema2);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b10.getText().toString());
                i.putExtra("day_cinema",cinema2);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b11.getText().toString());
                i.putExtra("day_cinema",cinema2);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b12.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b13.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b14.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b15.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b16.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b17.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b18.getText().toString());
                i.putExtra("day_cinema",cinema3);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b19.getText().toString());
                i.putExtra("day_cinema",cinema4);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b20.getText().toString());
                i.putExtra("day_cinema",cinema4);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Seat_Selection.class);
                i.putExtra("day_mname",mname);
                i.putExtra("day_mtime",b21.getText().toString());
                i.putExtra("day_cinema",cinema4);
                i.putExtra("day_id",id_tab);
                i.putExtra("name_day",dayname);
                startActivity(i);
            }
        });

        return view;

    }
}