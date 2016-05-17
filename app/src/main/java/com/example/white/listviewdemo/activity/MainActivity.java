package com.example.white.listviewdemo.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.white.listviewdemo.R;

public class MainActivity extends AppCompatActivity{

    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    private long currentTime;
    private ListView pointList;
    private String[] points = {"1.ListView与RecyclerView的使用",
                      "2.从网络读取数据",
                      "3.使用数据库缓存数据",
                      "4.Fragment 的使用",
                      "5.网络图片的加载"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar
                , R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, points);
        pointList = (ListView) findViewById(R.id.point_listview);
        pointList.setAdapter(adapter);
    }

    public void closeMenu() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawers();
            return;
        }
        if (System.currentTimeMillis() - currentTime > 3000) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            currentTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }
}
