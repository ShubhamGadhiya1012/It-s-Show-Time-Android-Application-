package com.example.advance_gtu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile_Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Profile_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile_Home newInstance(String param1, String param2) {
        Profile_Home fragment = new Profile_Home();
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

    public My_Helper mh;
    public String profile_id,profile_fname,profile_lname,profile_uname,profile_email,profile_phone;
    TextView pro_key,pro_uname,pro_name,pro_phone,pro_email;
    Button pro_edit,pro_delete;
    My_Helper my_db;
    ArrayAdapter<String> aa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile__home, container, false);
        pro_key = view.findViewById(R.id.profileid);
        pro_uname = view.findViewById(R.id.profile_uname);
        pro_name = view.findViewById(R.id.profile_name);
        pro_phone = view.findViewById(R.id.profile_phone);
        pro_email = view.findViewById(R.id.profile_email);
        pro_edit = view.findViewById(R.id.btn_update);
        pro_delete = view.findViewById(R.id.btn_prodel);
        profile_id = getArguments().getString("idKey");

        Intent login_home = new Intent(getActivity(),MainActivity.class);

        my_db = new My_Helper(getActivity());

        Cursor c = my_db.getAllData(profile_id);

        c.moveToFirst();
        while(! c.isAfterLast()){
            profile_id = c.getString(0);
            profile_fname = c.getString(1);
            profile_lname = c.getString(2);
            profile_phone = c.getString(3);
            profile_email = c.getString(4);
            profile_uname = c.getString(5);
            c.moveToNext();
        }
        c.close();

        pro_key.setText(profile_id);
        pro_uname.setText(profile_uname);
        pro_name.setText(profile_fname+" "+profile_lname);
        pro_phone.setText(profile_phone);
        pro_email.setText(profile_email);

        pro_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent editintent = new Intent(getActivity(),Edit_Profile.class);
                editintent.putExtra("editid",profile_id);
                startActivity(editintent);


            }
        });

        pro_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                my_db.deleteuser(profile_id);
                startActivity(login_home);

            }
        });




        return view;
    }

}