package com.example.user_pc.iotapp.helper;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseRefreshToken extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refrehedToken = FirebaseInstanceId.getInstance().getToken();

        if (refrehedToken != null){
            PreferencesHelper preferencesHelper = new PreferencesHelper(this);
            preferencesHelper.setFCMToken(refrehedToken);
        }

        Log.d("asa", refrehedToken);
    }
}
