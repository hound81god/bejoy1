package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    View l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView2);
        l = findViewById(R.id.linearLayout);
    }

    public void eventHandler(View view) {
        if(button.getText() == "Submit")
            button.setText("Click me");
        else
            button.setText("Submit");

    }

    public void eventHandlerbg(View view) {
        l.setBackgroundColor(RED);
    }

    public void eventHandlerf(View view) {
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
    }

    public void eventHandlerfc(View view) {
                textView.setTextColor(BLUE);
    }
}