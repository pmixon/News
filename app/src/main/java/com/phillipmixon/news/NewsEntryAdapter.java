package com.phillipmixon.news;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phill on 1/17/2018.
 */

public class NewsEntryAdapter extends ArrayAdapter<NewsEntry>{


    public NewsEntryAdapter(@NonNull Context context, ArrayList<NewsEntry> newsEntries) {
        super(context, 0, newsEntries);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View newsView = convertView;
        if (newsView == null) {
            newsView = LayoutInflater.from(getContext()).inflate(R.layout.news_entry,parent, false);
        }

        final NewsEntry currentNewsEntry = getItem(position);

        TextView titleTextView = (TextView) newsView.findViewById(R.id.title);
        titleTextView.setText(currentNewsEntry.getTitle());

        TextView sectionTextView = (TextView) newsView.findViewById(R.id.section);
        sectionTextView.setText(currentNewsEntry.getSection());

        TextView dateTextView = (TextView) newsView.findViewById(R.id.date_published);
        dateTextView.setText(currentNewsEntry.getDate_published());

        return newsView;
    }
}
