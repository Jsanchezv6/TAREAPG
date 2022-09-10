package com.example.tareaandroidrestaurante;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RestauranteFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurante;
    List<Restaurante> restauranteList;
    OnListFragmentInteractionListener mlistener = null;

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    public RestauranteFragment() {
    }

    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("El Alboroto", "https://restauranteelalboroto.somostodogt.com/wp-content/uploads/2022/03/logo_alboroto.png", 5.0f, "Jalapa, Jalapa"));
            restauranteList.add(new Restaurante("Pollo Campero", "https://play-lh.googleusercontent.com/NVmSMvOxV2QbyAaqEVx4l5xo8-9KLxsZkgsCWhu2kfVpgSKy9V8TY6Qy813OX--5INE", 5.0f, "Jalapa, Jalapa"));
            restauranteList.add(new Restaurante("Burguer Diner", "https://aditelgt.com/wp-content/uploads/2019/05/FB_IMG_1556852645690.jpg", 5.0f, "Jalapa, Jalapa"));
            restauranteList.add(new Restaurante("Dominos Pizza", "https://i.pinimg.com/564x/1b/ee/08/1bee08aa56544de70e0c6bffe4a944a4.jpg", 5.0f, "Jalapa, Jalapa"));

            adapterRestaurante = new MyRestauranteRecyclerViewAdapter(getContext(),restauranteList, mlistener);

            recyclerView.setAdapter(adapterRestaurante);
        }
        return view;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Restaurante item);

    }
}