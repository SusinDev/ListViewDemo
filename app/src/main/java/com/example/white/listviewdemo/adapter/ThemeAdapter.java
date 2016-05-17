package com.example.white.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.white.listviewdemo.R;
import com.example.white.listviewdemo.model.Theme;

import java.util.List;

/**
 * Created by white on 2016/5/12.
 */
public class ThemeAdapter extends BaseAdapter {

    private List<Theme> menuItem;
    Context context;

    public ThemeAdapter(Context context, List<Theme> menuItem) {
        this.context = context;
        this.menuItem = menuItem;
    }

    @Override
    public int getCount() {
        return menuItem.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        Theme theme = (Theme) getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.iv_title = (ImageView) convertView.findViewById(R.id.iv_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_title.setImageResource(theme.getImageViewid());
        viewHolder.tv_title.setText(theme.getName());
        return convertView;
    }

    private class ViewHolder {
        TextView tv_title;

        ImageView iv_title;
    }
}
