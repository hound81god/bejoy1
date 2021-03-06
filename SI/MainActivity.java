package com.example.simpleinterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnCLick();
    }

    EditText amt, interest, time;
    Button btn;
    TextView txt1, txt2;

    public void OnCLick() {
        amt = (EditText) findViewById(R.id.amt);
        interest = (EditText) findViewById(R.id.interest);
        time = (EditText) findViewById(R.id.tim);
        btn = (Button) findViewById(R.id.btn);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(amt.getText().toString());
                int b = Integer.parseInt(interest.getText().toString());
                int c = Integer.parseInt(time.getText().toString());
                int d;
                d = (a * b * c) / 100;
                int e = a + d;

                txt1.setText("Total Interest Is :" + String.valueOf(d));
                txt2.setText("Total Amount is : " + String.valueOf(e));

            }
        });
    }
}
