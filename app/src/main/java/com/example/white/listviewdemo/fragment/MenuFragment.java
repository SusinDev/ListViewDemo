package com.example.white.listviewdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.white.listviewdemo.R;

/**
 * Created by white on 2016/5/9.
 */
public class MenuFragment extends Fragment {

    private ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mListView = (ListView) view.findViewById(R.id.listview_menu);
        //为菜单项准备好数据，用的是ArrayAdapter的方式绑定ListView
        String[] menuItem = {"SimpleAdapter的方式", "BaseAdapter的方式"};
        ArrayAdapter<String> menu = new ArrayAdapter<String>(getActivity(),
                                    android.R.layout.simple_list_item_1,menuItem);
        mListView.setAdapter(menu);
        return view;
    }
}
