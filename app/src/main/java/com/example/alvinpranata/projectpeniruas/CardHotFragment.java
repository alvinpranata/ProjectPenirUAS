package com.example.alvinpranata.projectpeniruas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardHotFragment extends Fragment {
    public static RecyclerView recyclerView;
    public static RecycleAdapter recycleAdapter;

    //Constructor sebagai pengganti consttucotr berparameter karena fragment hanya boleh mempunyai satu constructor

    public static CardHotFragment newInstance(ArrayList<Post> posts){
        CardHotFragment cf = new CardHotFragment();
        recycleAdapter = new RecycleAdapter(posts);
        return cf;
    }

    public CardHotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_content,container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);

        LinearLayoutManager manager =  new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleAdapter);

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_card_content, container, false);
    }

}
