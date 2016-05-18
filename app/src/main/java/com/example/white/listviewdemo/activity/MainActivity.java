package com.example.white.listviewdemo.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.white.listviewdemo.R;
import com.example.white.listviewdemo.db.DBManager;
import com.example.white.listviewdemo.fragment.MainFragment;

public class MainActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private SwipeRefreshLayout mRefreshLayout;
    private FrameLayout mFrameLayout;
    private Button enterButton;
    private long currentTime;
    private ListView pointList;
    private String[] points = {"1.ListView与RecyclerView的使用",
                      "2.从网络读取数据",
                      "3.使用数据库缓存数据",
                      "4.Fragment 的使用",
                      "5.网络图片的加载"};
    private DBManager mDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mFrameLayout = (FrameLayout) findViewById(R.id.introduce);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshlayout);
        pointList = (ListView) findViewById(R.id.point_listview);
        enterButton = (Button) findViewById(R.id.enter);
        mDBManager = DBManager.getInstance(getApplicationContext());

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar
                , R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, points);
        pointList.setAdapter(adapter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.introduce, new MainFragment("999","首页"))
                        .commit();
            }
        });
    }

    public void closeMenu() {
        mDrawerLayout.closeDrawers();
    }

    public void showSnackBar(String tips) {
        Snackbar.make(mFrameLayout, tips, Snackbar.LENGTH_SHORT).show();
    }

    public void setRefreshEnable(boolean isRefreshEnable){
        mRefreshLayout.setEnabled(isRefreshEnable);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDBManager != null) {
            mDBManager.release();
        }
    }
}
