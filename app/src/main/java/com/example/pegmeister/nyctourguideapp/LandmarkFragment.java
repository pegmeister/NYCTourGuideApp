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
public class LandmarkFragment extends Fragment {

    public LandmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_listview, container, false);

        // create a list of landmark items
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getString(R.string.Central), getString(R.string.cp_loc), R.drawable.central_park, getString(R.string.cp_web)));
        items.add(new Item(getString(R.string.Rockefeller), getString(R.string.rc_loc), R.drawable.rockefeller, getString(R.string.rc_web)));
        items.add(new Item(getString(R.string.guggenheim), getString(R.string.gug_loc), R.drawable.guggenheim, getString(R.string.gug_web)));
        items.add(new Item(getString(R.string.National), getString(R.string.national_loc), R.drawable.national911, getString(R.string.national_web)));
        items.add(new Item(getString(R.string.Empire), getString(R.string.es_loc), R.drawable.empire, getString(R.string.es_web)));
        items.add(new Item(getString(R.string.liberty), getString(R.string.liberty_loc), R.drawable.liberty, getString(R.string.liberty_web)));

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



