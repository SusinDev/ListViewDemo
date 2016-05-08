package com.example.white.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by white on 2016/5/9.
 */
public class NewsListItemAdapter extends BaseAdapter {

    Context context;
    private int resourceId;
    private List<NewsListItem> items;

    public NewsListItemAdapter(Context context, int resourceId, List<NewsListItem> items) {
        this.context = context;
        this.resourceId = resourceId;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsListItem newsListItem = (NewsListItem) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(resourceId, parent, false);
            viewHolder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_item.setText(newsListItem.getId());
        viewHolder.tv_item.setText(newsListItem.getTitle());
        return convertView;
    }

    public static class ViewHolder {
        TextView tv_item;
    }
}
