package com.phillipmixon.news;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by phill on 1/17/2018.
 */

public class NewsEntryLoader extends AsyncTaskLoader<List<NewsEntry>> {

    private String mDataUrl;

    public NewsEntryLoader(Context context) {
        super(context);
    }

    public NewsEntryLoader(Context context, String url) {
        super(context);
        mDataUrl = url;
    }

    @Override
    public List<NewsEntry> loadInBackground() {
        return QueryUtils.fetchNewsData(mDataUrl);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
