package com.example.user_pc.iotapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.user_pc.iotapp.model.User;

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;
    private final String PREFERENCE_NAME = "shared_prederences";
    private final String LOGIN = "login";
    private final String TOKEN = "token";
    private final String ID = "id";
    private final String NAME = "name";
    private final String EMAIL = "email";
    private final String PERMISSION = "permission";
    private final String FCM_TOKEN = "fcm_token";

    public PreferencesHelper(Context context){
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void setLogin(boolean login){
        sharedPreferences.edit().putBoolean(LOGIN, login).apply();
    }

    public boolean getLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void setToken(String token){
        sharedPreferences.edit().putString(TOKEN, token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, "");
    }

    public void setId(int id){
        sharedPreferences.edit().putInt(ID, id).apply();
    }

    public int getID() {
        return sharedPreferences.getInt(ID, 0);
    }

    public void setName(String name){
        sharedPreferences.edit().putString(NAME, name).apply();
    }

    public String getName() {
        return sharedPreferences.getString(NAME, "");
    }

    public void setEmail(String email){
        sharedPreferences.edit().putString(EMAIL, email).apply();
    }

    public String getEmail() {
        return sharedPreferences.getString(EMAIL, "");
    }

    public void setPermission(int permission){
        sharedPreferences.edit().putInt(PERMISSION, permission).apply();
    }

    public int getPermission() {
        return sharedPreferences.getInt(PERMISSION, 0);
    }

    public void setFCMToken(String fcmToken){
        sharedPreferences.edit().putString(FCM_TOKEN, fcmToken).apply();
    }

    public String getFCMToken() {
        return sharedPreferences.getString(FCM_TOKEN, "");
    }

    public void setUserLogin(User user){
        setLogin(true);
        setToken(user.getToken());
        setName(user.getName());
        setEmail(user.getEmail());
        setPermission(user.getPermission());
    }

    public void logout(){
        sharedPreferences.edit()
                .clear()
                .apply();
    }
}
