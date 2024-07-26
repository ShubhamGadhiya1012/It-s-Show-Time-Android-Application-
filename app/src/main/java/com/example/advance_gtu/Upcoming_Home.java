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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Upcoming_Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Upcoming_Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Upcoming_Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Upcoming_Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Upcoming_Home newInstance(String param1, String param2) {
        Upcoming_Home fragment = new Upcoming_Home();
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

    GridView simpleGrid_2;
    String[] movie_name = {"Brahmāstra: Part One – Shiva","Black Panther: Wakanda Forever","Vikram Vedha","Bhediya","Thank God","Ram Setu","Black Adam",
            "Enola Holmes","Drishyam 2","Violent Night"};
    String[] discription = {"The Brahmashirsha astra was a weapon that was said to be able to destroy the world, capable of destroying creation and vanquishing all beings. It is one of the most destructive, powerful, and irresistible weapons mentioned in Hinduism. These weapons are all created by Lord Brahma.",
            "Wakanda, officially known as the Kingdom of Wakanda, is a small isolationist landlocked country located in Africa, surrounded by mountain ranges and a thick jungle. It is one of the most technologically advanced nations on Earth, known for its rich deposits of the element vibranium.",
            "Inspired by the Indian folktale Baital Pachisi, the film tells the story of Vikram, a police inspector who sets out to track down and kill Vedha, a gangster. After Vedha voluntarily surrenders himself, he tells Vikram three stories which change his perceptions of good and evil. ",
            "Bhediya ( transl. Werewolf) is an upcoming Indian Hindi-language comedy horror film directed by Amar Kaushik. Produced by Dinesh Vijan, it stars Varun Dhawan and Kriti Sanon. The film is the third installment in Dinesh Vijan's horror-comedy universe.",
            "Thank God is an upcoming Indian Hindi-language comedy film written and directed by Indra Kumar with production by T-Series and Maruti International. The film features Ajay Devgn, Sidharth Malhotra and Rakul Preet Singh in the lead roles. The film is scheduled for release on 24 October 2022 coinciding with Diwali.",
            "Ram Setu is a chain of limestone shoals between the coasts of India and Sri Lanka. According to the epic Ramayana, the bridge was built by the 'Vanara army' to rescue Sita, who was kidnapped by Ravana. ",
            "As originally depicted, Black Adam was a corrupted, ancient Egyptian predecessor of Captain Marvel, who fought his way to modern times to challenge the hero and his Marvel Family associates. ",
            "Enola Holmes-Sherlock's teen sister-discovers her mother is missing, she sets off to find her, becoming a super-sleuth in her own right as she outwits her famous brother and unravels a dangerous conspiracy around a mysterious young Lord. England, 1884 - a world on the brink of change.",
            "The film is a remake of the 2021 film of the same name and is a sequel to Drishyam (2015 film).",
            "A group of mercenaries attack the estate of a wealthy family on Christmas Eve, and Santa must save Christmas. A group of mercenaries attack the estate of a wealthy family on Christmas Eve, and Santa must save Christmas."};
    int poster_upcoming[] = {R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,R.drawable.t6,
            R.drawable.t7,R.drawable.t8,R.drawable.t9,R.drawable.t10};

    int official_trailer[] = {R.drawable.brahmastra, R.drawable.blackpanther,R.drawable.vikramvedha, R.drawable.bhediya,
            R.drawable.thankgod, R.drawable.ramsetu, R.drawable.blackadam,R.drawable.enolaholmes, R.drawable.drishyam2,
            R.drawable.violentnight};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_upcoming__home, container, false);

        simpleGrid_2 = (GridView)view.findViewById(R.id.grid_view2);
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapter_2 grid_adapter = new CustomAdapter_2(getActivity(),poster_upcoming);
        simpleGrid_2.setAdapter(grid_adapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity

//                Toast.makeText(getActivity(), "You click on " , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), Upcoming_Description.class);
                intent.putExtra("imgPos",position);
                intent.putExtra("image", official_trailer[position]);
                intent.putExtra("discription", discription[position]);
                intent.putExtra("movie_name", movie_name[position]);
                startActivity(intent);

            }
        });


        return view;
    }
}