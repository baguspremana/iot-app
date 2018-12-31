package com.example.user_pc.iotapp.user.saldouser;

import com.example.user_pc.iotapp.api.ApiService;
import com.example.user_pc.iotapp.model.RekeningResponse;
import com.example.user_pc.iotapp.model.RekeningUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaldoPresenter {
    private SaldoView view;
    private ApiService service;

    public SaldoPresenter(SaldoView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void showSaldo(){
        view.showLoading();
        service.showSaldo()
                .enqueue(new Callback<List<RekeningResponse>>() {
                    @Override
                    public void onResponse(Call<List<RekeningResponse>> call, Response<List<RekeningResponse>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<RekeningResponse>> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
