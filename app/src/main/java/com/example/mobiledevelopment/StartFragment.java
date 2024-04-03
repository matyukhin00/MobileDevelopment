package com.example.mobiledevelopment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class StartFragment extends Fragment {
    public StartFragment() {
        super(R.layout.fragment_start);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        view.findViewById(R.id.buttonToList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String info = "Данные, переданные из StartFragment в ListFragment";
                bundle.putString("listKey", info);
                Navigation.findNavController(v).navigate(R.id.startToList, bundle);
            }
        });
        view.findViewById(R.id.buttonToRecycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String info = "Данные, переданные из StartFragment в RecyclerFragment";
                bundle.putString("recyclerKey", info);
                Navigation.findNavController(v).navigate(R.id.startToRecycler, bundle);
            }
        });
        return view;
    }
}

