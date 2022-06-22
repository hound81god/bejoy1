package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    LinearLayout view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.layout);
        DrawRect rect = new DrawRect(this);
        view.addView(rect);
    }

    public class DrawRect extends View {
        public DrawRect(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint myPaint = new Paint();
            myPaint.setColor(Color.YELLOW);
            myPaint.setStyle(Paint.Style.FILL);
            Paint eye = new Paint();
            eye.setColor(Color.BLACK);
            eye.setStyle(Paint.Style.FILL);
//            canvas.drawRect(60, 80, 600, 400, myPaint);
//            canvas.drawCircle(500, 700, 100, myPaint);
//            canvas.drawLine(500,700,500,1000,myPaint);
            canvas.drawCircle(500, 700, 200, myPaint);
            canvas.drawCircle(410, 650, 50, eye);
            canvas.drawCircle(580, 650, 50, eye);
            RectF rectF = new RectF(400, 650, 600, 800);
            canvas.drawArc(rectF, 0F, 180F, true, eye);

        }
    }
}