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
public class MustSeeFragment extends Fragment {

    public MustSeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.item_listview, container, false);

        // create a list of must-see items
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getString(R.string.cathedral), getString(R.string.cathedral_loc), R.drawable.cathedral, getString(R.string.cathedral_web)));
        items.add(new Item(getString(R.string.MET), getString(R.string.met_loc), R.drawable.met, getString(R.string.met_web)));
        items.add(new Item(getString(R.string.square), getString(R.string.ts_loc), R.drawable.times_square, getString(R.string.ts_web)));
        items.add(new Item(getString(R.string.village), getString(R.string.village_loc), R.drawable.greenwich, getString(R.string.village_web)));
        items.add(new Item(getString(R.string.stone), getString(R.string.stone_loc), R.drawable.stone, getString(R.string.stone_web)));
        items.add(new Item(getString(R.string.radio), getString(R.string.radio_loc), R.drawable.radio, getString(R.string.radio_web)));

        // create an ItemAdapter
        final ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        // get list view
        ListView listView = rootview.findViewById(R.id.list);

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

        return rootview;
    }
}
