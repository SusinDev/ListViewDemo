package com.example.white.listviewdemo.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.white.listviewdemo.R;

/**
 * Created by white on 2016/5/17.
 */
@SuppressLint("ValidFragment")
public class NewsFragment extends Fragment {

    private String urlId;
    private String title;


    public NewsFragment(String id, String title) {
        urlId = id;
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }
}
