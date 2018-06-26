package com.example.pegmeister.nyctourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    // ItemAdapter constructor
    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolderItem viewHolder;

        //Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        // If listItemView is null, inflate it from list_item
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            // setup the ViewHolder
            viewHolder = new ViewHolderItem();

            // Find the TextView in the list_item layout with the ID title, location, ratings and image.
            viewHolder.title = listItemView.findViewById(R.id.title);
            viewHolder.location = listItemView.findViewById(R.id.location);
            viewHolder.image = listItemView.findViewById(R.id.image);

            // store the holder with the view
            listItemView.setTag(viewHolder);

        } else {

            // avoid frequent calling of findViewById(), just use viewHolder
            viewHolder = (ViewHolderItem) listItemView.getTag();
        }

        // get the current item with position id
        Item currentItem = getItem(position);

        if (currentItem != null) {
            // get item from currentItem and set it to title, location, ratings TextView and image id.
            viewHolder.title.setText((currentItem.getItemTitle()));
            viewHolder.location.setText(currentItem.getItemLocation());
            viewHolder.image.setImageResource(currentItem.getItemImageResourceId());

        }

        // return the view
        return listItemView;
    }

    // create ViewHolder class to improve scrolling performance
    static class ViewHolderItem {
        TextView title;
        TextView location;
        ImageView image;
    }
}
