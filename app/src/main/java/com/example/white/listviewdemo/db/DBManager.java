package com.example.white.listviewdemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by white on 2016/5/18.
 */
public class DBManager {

    private static int sVersion = 1;
    private static Context sContext;
    public static int count;
    private SQLiteDatabase db;
    DbHelper dbHelper;

    private static String themeCulumn = "666";


    private DBManager(Context context, int version) {
        dbHelper = new DbHelper(context, version);
    }

    public static DBManager getInstance(Context context) {
        count++;
        sContext = context;
        return SingletonHolder.sDBManager;
    }

    /**
     * 单例模式-静态内部类实现
     */
    private static class SingletonHolder {
        private static DBManager sDBManager = new DBManager(sContext, sVersion);
    }

    public void saveThemes(String data) {
        db = dbHelper.getWritableDatabase();
        if (null != data) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", themeCulumn);
            contentValues.put("json", data);
            db.replace(DbHelper.THEMES_TABLE_NAME, null, contentValues);
        }
        db.close();
    }

    public String getThemes() {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from themes where id = ?", new String[]{String.valueOf(themeCulumn)});
        String result = null;
        while (cursor.moveToNext()) {
            result = cursor.getString(cursor.getColumnIndex("json"));
        }
        return result;
    }


    public void release() {
        count--;
        if (count == 0) {
            db.close();
            SingletonHolder.sDBManager = null;
        }
    }
}




