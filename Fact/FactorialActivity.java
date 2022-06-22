package com.example.factorialintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        Bundle b = getIntent().getExtras();

        int no = Integer.parseInt(b.getString("number"));
        long f = 1;

        for (int i = no; i > 0; i--) {
            f = f * i;
        }

        tv = findViewById(R.id.tv);
        tv.setText("Factorial of " + no + " is " + f);
    }
}