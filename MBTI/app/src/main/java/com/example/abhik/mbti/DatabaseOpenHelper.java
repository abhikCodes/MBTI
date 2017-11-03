package com.example.abhik.mbti;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by abhik on 26/10/17.
 */

public class DatabaseOpenHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "MBTI.db";
    private static final int DATABASE_VERSION = 1;
//    Context context;
//    PlaceholderFragment fragment = new PlaceholderFragment();

//    public DatabaseOpenHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
////        context = fragment.getActivity();
//    }



    public DatabaseOpenHelper(MBTIquestionarre context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }


}
