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
public class CardFreshFragment extends Fragment {
    public static RecyclerView recyclerViewFresh;
    public static RecycleAdapter recycleAdapterFresh;

    public CardFreshFragment() {
        // Required empty public constructor
    }
    public static CardHotFragment newInstance(ArrayList<Post> posts){
        CardHotFragment cf = new CardHotFragment();
        recycleAdapterFresh = new RecycleAdapter(posts);
        return cf;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_daily,container, false);
        recyclerViewFresh = (RecyclerView) view.findViewById(R.id.recycleFresh);

        LinearLayoutManager manager =  new LinearLayoutManager(getContext());
        recyclerViewFresh.setLayoutManager(manager);
        recyclerViewFresh.setHasFixedSize(true);
        recyclerViewFresh.setAdapter(recycleAdapterFresh);

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_card_daily, container, false);
    }

}
