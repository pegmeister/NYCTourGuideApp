package com.example.pegmeister.nyctourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiningFragment extends Fragment {

    public DiningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        // create a list of dining items
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getString(R.string.cull), getString(R.string.cull_loc), R.drawable.cull_pistol, getString(R.string.cull_web)));
        items.add(new Item(getString(R.string.tree), getString(R.string.tree_loc), R.drawable.tree_bistro, getString(R.string.tree_web)));
        items.add(new Item(getString(R.string.decoy), getString(R.string.decoy_loc), R.drawable.decoy, getString(R.string.decoy_web)));
        items.add(new Item(getString(R.string.gotham), getString(R.string.gotham_loc), R.drawable.gotham, getString(R.string.gotham_web)));
        items.add(new Item(getString(R.string.club), getString(R.string.club_loc), R.drawable.club_a, getString(R.string.club_web)));
        items.add(new Item(getString(R.string.modern), getString(R.string.modern_loc), R.drawable.the_modern, getString(R.string.modern_web)));

        // create an ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        // get list view
        ListView listView = rootView.findViewById(R.id.list);

        // set adapter
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Item item = items.get(i);
                String website = item.getInformation();
                Intent openwebsite = new Intent(Intent.ACTION_VIEW);
                openwebsite.setData(Uri.parse(String.valueOf(website)));
                startActivity(openwebsite);
            }
        });

        return rootView;
    }
}
