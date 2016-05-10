package com.example.white.listviewdemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.white.listviewdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by white on 2016/5/10.
 */
public class SimpleAdapterFragment extends Fragment {

    private ListView listView_simpleAdapter;
    private List<Map<String, Object>> simpleAdapterItem;
    private SimpleAdapter simpleAdapter;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simpleadapter, container, false);
        listView_simpleAdapter = (ListView) view.findViewById(R.id.listview_simpleadapter);
        simpleAdapterItem = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(getActivity(), getData(), R.layout.item_simpleadapter,
                new String[]{"pic", "text"}, new int[]{R.id.simple_pic, R.id.simple_text});
        listView_simpleAdapter.setAdapter(simpleAdapter);
        return view;
    }

    private List<Map<String, Object>> getData() {
        for (int i=0;i<20;i++) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("pic", R.mipmap.ic_launcher);
            data.put("text", "Android" + i);
            simpleAdapterItem.add(data);
        }
        return  simpleAdapterItem;
    }
}
