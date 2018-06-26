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


public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        // create a list of shopping items
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getString(R.string.bloomie), getString(R.string.bloomie_loc), R.drawable.bloomingdales, getString(R.string.bloomie_web)));
        items.add(new Item(getString(R.string.girl), getString(R.string.girl_loc), R.drawable.american_girl, getString(R.string.girl_web)));
        items.add(new Item(getString(R.string.tiffany), getString(R.string.tiffany_loc), R.drawable.tiffany, getString(R.string.tiffany_web)));
        items.add(new Item(getString(R.string.design), getString(R.string.design_loc), R.drawable.moma, getString(R.string.design_web)));
        items.add(new Item(getString(R.string.goodman), getString(R.string.goodman_loc), R.drawable.bergdorf1, getString(R.string.goodman_web)));
        items.add(new Item(getString(R.string.nba), getString(R.string.nba_loc), R.drawable.nba, getString(R.string.nba_web)));

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






