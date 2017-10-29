package com.example.abhik.mbti;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by abhik on 26/10/17.
 */

public class DatabaseOpenHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "MBTI.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
