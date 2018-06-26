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

        // If listItemView is null, inflate it from list_item
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            // setup the ViewHolder
            viewHolder = new ViewHolderItem();

            // Find the TextView in the list_item layout with the ID title, location, ratings and image.
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.location = convertView.findViewById(R.id.location);
            viewHolder.image = convertView.findViewById(R.id.image);

            // store the holder with the view
            convertView.setTag(viewHolder);

        } else {

            // avoid frequent calling of findViewById(), just use viewHolder
            viewHolder = (ViewHolderItem) convertView.getTag();
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
        return convertView;
    }

    // create ViewHolder class to improve scrolling performance
    static class ViewHolderItem {
        TextView title;
        TextView location;
        ImageView image;
    }
}
