package com.example.mobiledevelopment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    public ListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = view.findViewById(R.id.listView);
        List<Item> listItems = new ArrayList<>();
        for (int i=0; i<200; i++) {
            listItems.add(new Item(R.drawable.skull1, String.valueOf(i+1)));
        }
        ListAdapter adapter = new ListAdapter(getContext(), R.layout.list_item, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Item " + (position+1), Toast.LENGTH_SHORT).show();
                Log.d("ListView", "Item " + (position+1));
            }
        });

        view.findViewById(R.id.buttonHomeList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.listToStart);
            }
        });
        assert getArguments() != null;
        String result = getArguments().getString("listKey");
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        return view;
    }
}
