package com.example.user_pc.iotapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user_pc.iotapp.admin.AdminActivity;
import com.example.user_pc.iotapp.auth.LoginActivity;
import com.example.user_pc.iotapp.helper.ConstantURL;
import com.example.user_pc.iotapp.helper.PreferencesHelper;
import com.example.user_pc.iotapp.user.UserActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        preferencesHelper=new PreferencesHelper(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                if (preferencesHelper.getLogin()){
                    if (preferencesHelper.getPermission()==ConstantURL.Permission.USER){
                        intent = new Intent(SplashScreenActivity.this, UserActivity.class);
                    }else if (preferencesHelper.getPermission()==ConstantURL.Permission.ADMIN){
                        intent = new Intent(SplashScreenActivity.this, AdminActivity.class);
                    }
                }else {
                    intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
