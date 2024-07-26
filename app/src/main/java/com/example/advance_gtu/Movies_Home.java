package com.example.advance_gtu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.advance_gtu.databinding.ActivityMainBinding;
import com.example.advance_gtu.fragments.Monday;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Movies_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Movies_Home extends Fragment  {

    ActivityMainBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Movies_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Movies_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Movies_Home newInstance(String param1, String param2) {
        Movies_Home fragment = new Movies_Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);




        }
    }


    GridView simpleGrid;
    String[] moviesname = {"Liger (HINDI)","Karthikeya 2","Fakt Mahilao Maate ","Thor: Love and Thunder",
                            "Laal Singh Chaddha","Rocketry: The Nambi Effect","Naadi Dosh ","Doctor Strange",
                            "Rashtra Kavach Om","Bhool Bhulaiyaa 2","Dear Father","Nikamma","Jugjugg Jeeyo","K.G.F: Chapter 2","RRR"};
    int poster[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
            R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o, };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies__home, container, false);
        Bundle bundle = new Bundle();
        Monday mon = new Monday();
        Registration reg = new Registration();



       String  idd2 = getArguments().getString("idKey");

        simpleGrid = (GridView)view.findViewById(R.id.grid_view);
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapter grid_adapter = new CustomAdapter(getActivity(),moviesname,poster);
        simpleGrid.setAdapter(grid_adapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity

        //      Toast.makeText(getActivity(), idd2, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(),Tab_Activity.class);

                intent.putExtra("mname", moviesname[position]);
                intent.putExtra("id_mhome", idd2);
                startActivity(intent);


            }
        });


        return view;
    }




}