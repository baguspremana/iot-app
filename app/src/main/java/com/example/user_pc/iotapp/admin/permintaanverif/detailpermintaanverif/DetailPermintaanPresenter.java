package com.example.user_pc.iotapp.admin.permintaanverif.detailpermintaanverif;

import com.example.user_pc.iotapp.api.ApiService;
import com.example.user_pc.iotapp.model.Response;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailPermintaanPresenter {
    private DetailPermintaanView view;
    private ApiService service;

    public DetailPermintaanPresenter(DetailPermintaanView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void verifikasi(int id){
        service.verifikasi(id)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
