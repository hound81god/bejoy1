package com.example.factorialintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber = findViewById(R.id.etNumber);
    }

    public void displayFactorial(View view) {

        Intent i = new Intent(MainActivity.this, FactorialActivity.class);
        i.putExtra("number", etNumber.getText().toString());
        startActivity(i);
    }
}