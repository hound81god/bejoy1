package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText to, subject, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = findViewById(R.id.toText);
        subject = findViewById(R.id.subjectText);
        msg = findViewById(R.id.msgText);
    }

    public void eventHandler(View view) {
        sendMail();
    }

    private void sendMail() {
        String List = to.getText().toString();
        String[] receivers = List.split(",");

        String subjectTxt = subject.getText().toString();
        String message = msg.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, receivers);
        intent.putExtra(Intent.EXTRA_SUBJECT, subjectTxt);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "choose a email address"));
    }
}