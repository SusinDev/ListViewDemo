package com.example.white.listviewdemo;

/**
 * Created by white on 2016/5/9.
 */
public class NewsListItem {

    private String title;
    private String id;

    public NewsListItem(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

}
