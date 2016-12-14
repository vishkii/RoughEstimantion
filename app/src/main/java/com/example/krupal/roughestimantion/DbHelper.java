package com.example.krupal.roughestimantion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Krupal on 11/29/2016.
 */

public class DbHelper extends SQLiteOpenHelper

{

    static String DATABASE_NAME="rough.db";
    public static final String TABLE_NAME="rough_count";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="CLARITY";
    public static final String COL_4="SIZE";
    public static final String COL_5="FLOROSENCE";
    public static final String COL_6="CUT";
    public static final String COL_7="CARATS";
    public static final String COL_8="RATE";
    public static final String COL_9="AMOUNT";



    public DbHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IF NOT EXISTS rough_count (ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME VARCHAR,CLARITY VARCHAR,SIZE VARCHAR,FLOROSENCE VARCHAR,CUT VARCHAR,CARATS VARCHAR,RATE VARCHAR,AMOUNT VARCHAR);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String rough_name,String rough_clarity,String rough_size,String rough_florosence,String rough_cut,String rough_carats,String rough_rate,String rough_amount){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,rough_name);
        contentValues.put(COL_3,rough_clarity);
        contentValues.put(COL_4,rough_size);
        contentValues.put(COL_5,rough_florosence);
        contentValues.put(COL_6,rough_cut);
        contentValues.put(COL_7,rough_carats);
        contentValues.put(COL_8,rough_rate);
        contentValues.put(COL_9,rough_amount);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


}

