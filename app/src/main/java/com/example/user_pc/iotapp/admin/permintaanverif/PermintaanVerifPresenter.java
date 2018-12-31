package com.example.user_pc.iotapp.admin.permintaanverif;

import com.example.user_pc.iotapp.api.ApiService;
import com.example.user_pc.iotapp.model.PermintaanVerif;
import com.example.user_pc.iotapp.model.PermintaanVerifResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PermintaanVerifPresenter {
    private PermintaanVerifView view;
    private ApiService service;

    public PermintaanVerifPresenter(PermintaanVerifView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void showList(){
        view.showLoading();
        service.showPermintaa()
                .enqueue(new Callback<List<PermintaanVerifResponse>>() {
                    @Override
                    public void onResponse(Call<List<PermintaanVerifResponse>> call, Response<List<PermintaanVerifResponse>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<PermintaanVerifResponse>> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
