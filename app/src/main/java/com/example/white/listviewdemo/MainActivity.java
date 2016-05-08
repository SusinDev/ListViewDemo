package com.example.white.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NewsListItem> items = new ArrayList<NewsListItem>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNewsListItems();
        NewsListItemAdapter madapter = new NewsListItemAdapter(MainActivity.this,
                R.layout.menu_item, items);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(madapter);
    }

    private void initNewsListItems() {
        NewsListItem a = new NewsListItem("日常心理学", "1");
        items.add(a);
        NewsListItem b = new NewsListItem("用户推荐日报", "2");
        items.add(b);
        NewsListItem c = new NewsListItem("电影日报", "3");
        items.add(c);
        NewsListItem d = new NewsListItem("不许无聊", "4");
        items.add(d);
        NewsListItem e = new NewsListItem("设计日报", "5");
        items.add(e);
    }
}
