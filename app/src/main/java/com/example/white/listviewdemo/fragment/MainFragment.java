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
 * Created by white on 2016/5/18.
 */
@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {

    private String urlId;
    private String name;

    public MainFragment(String id, String name) {
        urlId = id;
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
