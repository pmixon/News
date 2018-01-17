package com.phillipmixon.news;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsEntry>> {

    private static final String DATA_URL = "http://content.guardianapis.com/search?q=debates&api-key=test";
    private ArrayAdapter<NewsEntry> newsEntryArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(0, null, this);

        newsEntryArrayAdapter = new NewsEntryAdapter(MainActivity.this, new ArrayList<NewsEntry>());

        ListView newListView = (ListView) findViewById(R.id.news_list_view);
        newListView.setAdapter(newsEntryArrayAdapter);

        newListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NewsEntry currentNewsEntry = newsEntryArrayAdapter.getItem(i);

                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(currentNewsEntry.getWebUrl()));
                startActivity(intent);
            }
        });

    }

    @Override
    public Loader<List<NewsEntry>> onCreateLoader(int id, Bundle args) {
        return new NewsEntryLoader(MainActivity.this, DATA_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsEntry>> loader, List<NewsEntry> data) {
        newsEntryArrayAdapter.clear();

        if (data != null || !data.isEmpty()) {
            newsEntryArrayAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewsEntry>> loader) {
        ArrayList<NewsEntry> newsEntries = new ArrayList<NewsEntry>();
        newsEntryArrayAdapter.addAll(newsEntries);
    }
}
