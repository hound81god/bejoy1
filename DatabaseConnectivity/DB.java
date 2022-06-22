package com.example.databaseconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public DB( Context context) {
        super(context, "data.db", null, 1);
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table students(Name text,location text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void sav(String s, String s1) {
        ContentValues cv=new ContentValues();
        cv.put("Name",s);
        cv.put("location",s1);
        sqLiteDatabase.insert("students",null,cv);

    }

    public String retrieve(String s3) {
        Cursor c=sqLiteDatabase.query("students",null,"Name=?",new String[]{s3},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1)
        {
            return "doesnot exist";
        }
        String l=c.getString(c.getColumnIndexOrThrow("location"));
        return l;
    }
}
