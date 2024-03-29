package com.example.mobiledevelopment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

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
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, new ListFragment())
                        .addToBackStack(null).commit();
            }
        });
        view.findViewById(R.id.buttonToRecycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, new RecyclerFragment())
                        .addToBackStack(null).commit();
            }
        });
        return view;
    }
}

