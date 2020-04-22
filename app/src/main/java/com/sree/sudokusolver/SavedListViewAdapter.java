package com.sree.sudokusolver;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SavedListViewAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;

    public SavedListViewAdapter(Activity context, ArrayList<String> maintitle, ArrayList<String> subtitle) {
        super(context, R.layout.saved_list_item_layout, maintitle);
        this.context=context;
        this.maintitle= maintitle.toArray(new String[0]);
        this.subtitle= subtitle.toArray(new String[0]);

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.saved_list_item_layout, null,true);
        TextView titleText = rowView.findViewById(R.id.saved_date_item);
        TextView subtitleText = rowView.findViewById(R.id.saved_time_iten);
        titleText.setText(maintitle[position]);
        subtitleText.setText(subtitle[position]);

        return rowView;

    };
}
