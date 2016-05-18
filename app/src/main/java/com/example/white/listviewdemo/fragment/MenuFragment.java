package com.example.white.listviewdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.white.listviewdemo.R;
import com.example.white.listviewdemo.activity.MainActivity;
import com.example.white.listviewdemo.adapter.ThemeAdapter;
import com.example.white.listviewdemo.db.DBManager;
import com.example.white.listviewdemo.model.Theme;
import com.example.white.listviewdemo.util.HttpUtil;
import com.loopj.android.http.TextHttpResponseHandler;
import com.victor.loading.rotate.RotateLoading;

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
//    private TextView tv_main;
    private RotateLoading mRotateLoading;
    private DBManager mDBManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mActivity = getActivity();
        themeList = new ArrayList<Theme>();
        mListView = (ListView) view.findViewById(R.id.listview_menu);
        mRotateLoading = (RotateLoading) view.findViewById(R.id.rotateloading);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("id", (int) id - 1);
                if (id == 0) {

//                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.introduce, new MainFragment(
                                    themeList.get(position).getId(),
                                    themeList.get(position).getName()))
                            .commit();
                } else {

//                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.introduce, new NewsFragment(
                                    themeList.get(position).getId(),
                                    themeList.get(position).getName()))
                            .commit();
                }
                ((MainActivity)mActivity).closeMenu();
                ((MainActivity) mActivity).setRefreshEnable(true);
            }
        });
        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDBManager = DBManager.getInstance(mActivity.getApplicationContext());
        initData();
    }

    protected void initData() {
            HttpUtil.get("themes", new TextHttpResponseHandler(){

                @Override
                public void onStart() {
                    super.onStart();
                    mRotateLoading.start();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String response) {
                    mRotateLoading.stop();
                    handleResponse(response);
                    mDBManager.saveThemes(response.toString());
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String response, Throwable throwable) {
                    Log.d("MenuFragment","failure");
                    mRotateLoading.stop();
                    handleResponse(mDBManager.getThemes());
                }
            });
    }

    private void handleResponse(String response) {
        if (response == null) {
            return;
        }
        themeList = parseJson(response);
        Theme themes = new Theme();
        themes.setName("首页");
        themes.setId("999");
        themeList.add(0, themes);
        themeAdapter = new ThemeAdapter(mActivity, themeList);
        mListView.setAdapter(themeAdapter);
    }

    private List<Theme> parseJson(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("others");
            List<Theme> themesList = JSON.parseArray(jsonArray.toString(), Theme.class);
            return themesList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity = null;
    }

}