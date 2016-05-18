package com.example.white.listviewdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by white on 2016/5/18.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "listview.db";
    public static String THEMES_TABLE_NAME = "themes";
    public static String CREAT_THEMES_TABLE =
            "CREATE TABLE IF NOT EXISTS themes(" +
                "id INTEGER primary key," +
                "data INTEGER unique," +
                "json Text);";

    public DbHelper(Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_THEMES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
