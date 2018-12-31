package com.example.user_pc.iotapp.auth;

import com.example.user_pc.iotapp.model.User;

public interface AuthView {
    void onSuccess(User user);
    void onError();
    void onFailure(Throwable t);
}
