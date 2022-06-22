package com.example.railwayreservation;

//package com.example.railwayreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    RadioGroup radio;
    CheckBox ac;
    CalendarView calendarView;
    RadioButton r1, r2,r3;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        radio = findViewById(R.id.radioGrp);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        ac = findViewById(R.id.checkBox);
        calendarView = findViewById(R.id.calendarView);
        db  = new DB(MainActivity.this);
    }

    public void BookTicket(View view) {
        String Name = name.getText().toString();
        int Age = Integer.parseInt(age.getText().toString());
        int gender;
        if(r1.isSelected()){
            gender = 1;
        } else if(r2.isSelected()){
            gender = 2;
        } else  {
            gender = 3;
        }

        boolean AirCondition = ac.isSelected();
        Long date = calendarView.getDate();
        System.out.println(Name);
        System.out.println(Age);
        System.out.println(gender);
        System.out.println(AirCondition);
        System.out.println(date);
        db.sav(Name, Age, gender, AirCondition, date);
        System.out.println(db.retrieve(Name));
    }

    private class DB extends SQLiteOpenHelper {
        SQLiteDatabase sqLiteDatabase;
        public DB( Context context) {
            super(context, "data.db", null, 1);
            sqLiteDatabase=getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table RailwayTicket(Name text,age Number, gender Number, ac Boolean, date Number)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        public void sav(String s, Integer s1, Integer s2, Boolean s3, Long s4) {
            ContentValues cv=new ContentValues();
            cv.put("Name",s);
            cv.put("age",s1);
            cv.put("gender",s2);
            cv.put("ac",s3);
            cv.put("date",s4);
            sqLiteDatabase.insert("RailwayTicket",null,cv);
        }

        public String retrieve(String s3) {
            Cursor c=sqLiteDatabase.query("RailwayTicket",null,"Name=?",new String[]{s3},null,null,null);
            c.moveToFirst();
            if(c.getCount()<1)
            {
                return "doesnot exist";
            }
            String l=c.getString(c.getColumnIndexOrThrow("age"));
            return l;
        }

    }
}