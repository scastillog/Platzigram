package com.zephyrapp.platzigram.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zephyrapp.platzigram.R;
import com.zephyrapp.platzigram.adapter.PictureAdapterRecyclerView;
import com.zephyrapp.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home",false,view);
        RecyclerView picturesRecycler = (RecyclerView)view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);
        //Se crea un objeto del adapter
        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }


    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Uriel Remirez","4 dias", "3 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Uriel Remirez","4 dias", "3 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Uriel Remirez","4 dias", "3 Me Gusta"));
        return pictures;
    }

     public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
         ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
         ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
         ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}
