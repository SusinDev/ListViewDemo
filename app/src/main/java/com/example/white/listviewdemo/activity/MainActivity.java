package com.example.white.listviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.white.listviewdemo.R;
import com.example.white.listviewdemo.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MenuItem> items = new ArrayList<MenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}
