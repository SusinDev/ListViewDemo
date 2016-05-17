package com.example.white.listviewdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.white.listviewdemo.R;
import com.example.white.listviewdemo.activity.MainActivity;
import com.example.white.listviewdemo.adapter.ThemeAdapter;
import com.example.white.listviewdemo.model.Theme;
import com.example.white.listviewdemo.util.HttpUtil;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by white on 2016/5/9.
 */
public class MenuFragment extends Fragment {

    protected Activity mActivity;
    private ListView mListView;
    private List<Theme> themeList;
    private ThemeAdapter themeAdapter;
    private TextView tv_main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mActivity = getActivity();
        themeList = new ArrayList<Theme>();
        tv_main = (TextView) view.findViewById(R.id.tv_main);
        mListView = (ListView) view.findViewById(R.id.listview_menu);

        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.introduce, new MainFragmetn())
                        .commit();
                ((MainActivity)mActivity).closeMenu();
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.introduce, new NewsFragment())
                        .commit();
                ((MainActivity)mActivity).closeMenu();
            }
        });
        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected void initData() {
//        themeList = new ArrayList<Theme>();

            HttpUtil.get("themes", new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);
                    parsonJson(response);
                }
            });

    }

    private void parsonJson(JSONObject response) {
        try {
            JSONArray themesArray = response.getJSONArray("others");
            for (int i = 0; i < themesArray.length(); i++) {
                Theme themes = new Theme();
                JSONObject themeObject = themesArray.getJSONObject(i);
                themes.setName(themeObject.getString("name"));
                themes.setId(themeObject.getString("id"));
                themes.setImageViewid(R.mipmap.attack);
                themeList.add(themes);
            }
            themeAdapter = new ThemeAdapter(mActivity, themeList);
            mListView.setAdapter(themeAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity = null;
    }

}