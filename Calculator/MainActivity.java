package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    float a, b;
    boolean operatorUsed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void add1(View view) {
        textView.setText(textView.getText()+"1");
        Toast.makeText(MainActivity.this, "1 is pressed", Toast.LENGTH_LONG);
    }

    public void add2(View view) {
        textView.setText(textView.getText()+"2");
        Toast.makeText(MainActivity.this, "2 is pressed", Toast.LENGTH_LONG);
    }

    public void add3(View view) {
        textView.setText(textView.getText()+"3");
        Toast.makeText(MainActivity.this, "3 is pressed", Toast.LENGTH_LONG);
    }

    public void add4(View view) {
        textView.setText(textView.getText()+"4");
        Toast.makeText(MainActivity.this, "4 is pressed", Toast.LENGTH_LONG);
    }

    public void add5(View view) {
        textView.setText(textView.getText()+"5");
        Toast.makeText(MainActivity.this, "5 is pressed", Toast.LENGTH_LONG);
    }

    public void add6(View view) {
        textView.setText(textView.getText()+"6");
        Toast.makeText(MainActivity.this, "6 is pressed", Toast.LENGTH_LONG);
    }

    public void add7(View view) {
        textView.setText(textView.getText()+"7");
        Toast.makeText(MainActivity.this, "7 is pressed", Toast.LENGTH_LONG);
    }

    public void add8(View view) {
        textView.setText(textView.getText()+"8");
    }

    public void add9(View view) {
        textView.setText(textView.getText()+"9");
    }

    public void add0(View view) {
        textView.setText(textView.getText()+"0");
    }

    public void add(View view) {
        if(textView.getText() != "" && operatorUsed == false){
            textView.setText(textView.getText()+" + ");
            operatorUsed = true;
        } else if(operatorUsed == true){
            equal(view);
            textView.setText(textView.getText()+" + ");
            operatorUsed = true;
        }
    }

    public void sub(View view) {
        if(textView.getText() != "" && operatorUsed == false){
            textView.setText(textView.getText()+" - ");
            operatorUsed  = true;
        } else if(operatorUsed == true){
            equal(view);
            textView.setText(textView.getText()+" - ");
            operatorUsed = true;
        }
    }

    public void mul(View view) {
        if(textView.getText() != "" && operatorUsed == false){
            textView.setText(textView.getText()+" * ");
            operatorUsed  = true;
        }  else if(operatorUsed == true){
            equal(view);
            textView.setText(textView.getText()+" * ");
            operatorUsed = true;
        }
    }

    public void div(View view) {
        if(textView.getText() != "" && operatorUsed == false){
            textView.setText(textView.getText()+" / ");
            operatorUsed  = true;
        }  else if(operatorUsed == true){
            equal(view);
            textView.setText(textView.getText()+" / ");
            operatorUsed = true;
        }
    }

    public void equal(View view) {

        if(operatorUsed == true){
            String[] arr = textView.getText().toString().split(" ");
            for(int i=0;i<arr.length;i++)
                System.out.println(arr[i]);

            if(arr[1].equals("+")){
                double a = Double.parseDouble(arr[0])+Double.parseDouble(arr[2]);
                textView.setText(Double.toString(a));
                operatorUsed=false;
            } else if(arr[1].equals("-")){
                textView.setText(Double.toString(Double.parseDouble(arr[0])-Double.parseDouble(arr[2])));
                operatorUsed=false;
                System.out.println("-");
            } else if(arr[1].equals("*")){
                textView.setText(Double.toString(Double.parseDouble(arr[0])*Double.parseDouble(arr[2])));
                operatorUsed=false;
                System.out.println("*");
            } else if(arr[1].equals("/")) {
                if (Double.parseDouble(arr[2]) != 0.0) {
                    textView.setText(Double.toString(Double.parseDouble(arr[0]) / Double.parseDouble(arr[2])));
                    operatorUsed = false;
                    System.out.println("/");
                }
            }
        }
    }
}