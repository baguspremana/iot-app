package com.example.user_pc.iotapp.admin.listsaldouser;

import com.example.user_pc.iotapp.api.ApiService;
import com.example.user_pc.iotapp.model.TotalSaldoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaldoUserPresenter {
    private SaldoUserView view;
    private ApiService service;

    public SaldoUserPresenter(SaldoUserView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void showSaldoUser(){
        view.showLoading();
        service.showSaldoUser()
                .enqueue(new Callback<List<TotalSaldoUser>>() {
                    @Override
                    public void onResponse(Call<List<TotalSaldoUser>> call, Response<List<TotalSaldoUser>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<TotalSaldoUser>> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
