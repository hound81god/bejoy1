package com.example.emailnotification;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    EditText to,subject, msg;

    static final int RESULT = 1;

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

        String subjectTxt= subject.getText().toString();
        String message= msg.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,receivers);
        intent.putExtra(Intent.EXTRA_SUBJECT,subjectTxt);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        someActivityResultLauncher.launch(Intent.createChooser(intent,"choose a email address"));
        //        startActivity(Intent.createChooser(intent,"choose a email address"));
        //        startActivityForResult(Intent.createChooser(intent,"choose a email address"), RESULT);
    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                                shownofn();
                }
            });

    public void shownofn() {
        NotificationManager notificationManager = (NotificationManager)MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel mChannel = new NotificationChannel(channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this,channelId).setLargeIcon(BitmapFactory.decodeResource(MainActivity.this.getResources(), android.R.drawable.ic_media_play)).setSmallIcon(android.R.drawable.ic_media_play).setContentTitle("Notification By Gmail").setContentText("Email Sent!!!");

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent, 0);
        mBuilder.setContentIntent(pendingIntent);
        notificationManager.notify(notificationId,mBuilder.build());
    }

}