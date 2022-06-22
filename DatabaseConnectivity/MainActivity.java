package com.example.databaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText1;
    EditText editText2;
    Button b;
    Button b1;
    TextView textView;
    String s,s1,s3;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName);
        editText1=findViewById(R.id.editTextTextPersonName2);
        editText2=findViewById(R.id.editTextTextPersonName3);
        b=findViewById(R.id.button);
        b1=findViewById(R.id.button2);
        textView=findViewById(R.id.textView);
        db=new DB(MainActivity.this);

    }

    public void sav(View view) {
        s=editText.getText().toString();
        s1=editText1.getText().toString();
        db.sav(s,s1);
        editText.setText("");
        editText1.setText("");
        editText2.setText("");
        textView.setText("");
    }

    public void retrieve(View view) {
        s3=editText2.getText().toString();
        String loc=db.retrieve(s3);
        textView.setText(loc);
    }
}