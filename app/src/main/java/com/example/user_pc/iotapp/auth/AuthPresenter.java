package com.example.user_pc.iotapp.auth;

import com.example.user_pc.iotapp.api.ApiService;
import com.example.user_pc.iotapp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthPresenter {
    private AuthView view;
    private ApiService service;

    public AuthPresenter(AuthView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void login(String email, String password){
        service.login(email, password)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }

    public void register(String name, String email, String password){
        service.register(name, email, password)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
