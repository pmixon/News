package com.phillipmixon.news;

/**
 * Created by phill on 1/17/2018.
 */

public class NewsEntry {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    private String title;
    private String section;
    private String date_published;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    private String webUrl;

    public NewsEntry(String title, String section, String date_published, String webUrl) {
        this.title = title;
        this.section = section;
        this.date_published = date_published;
        this.webUrl = webUrl;
    }
}
