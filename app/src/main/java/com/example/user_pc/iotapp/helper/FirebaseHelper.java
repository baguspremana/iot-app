package com.example.user_pc.iotapp.helper;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.admin.AdminActivity;
import com.example.user_pc.iotapp.user.UserActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseHelper extends FirebaseMessagingService {
    private PreferencesHelper preferencesHelper;
    private Intent intent;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        preferencesHelper = new PreferencesHelper(this);
        String message = remoteMessage.getNotification().getBody();
        String title = remoteMessage.getNotification().getTitle();

        //On click of notification it redirect to this Activity
        if (preferencesHelper.getPermission()==0){
            intent = new Intent(this, UserActivity.class);
        }else {
            intent = new Intent(this, AdminActivity.class);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_notif)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
