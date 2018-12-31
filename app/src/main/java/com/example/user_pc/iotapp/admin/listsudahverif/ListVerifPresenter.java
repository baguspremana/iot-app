package com.example.user_pc.iotapp.admin.listsudahverif;

import com.example.user_pc.iotapp.api.ApiService;
import com.example.user_pc.iotapp.model.SaldoVerif;
import com.example.user_pc.iotapp.model.SaldoVerifResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListVerifPresenter {
    private ListVerifView view;
    private ApiService service;

    public ListVerifPresenter(ListVerifView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void showVerif(){
        view.showLoading();
        service.showVerif()
                .enqueue(new Callback<List<SaldoVerif>>() {
                    @Override
                    public void onResponse(Call<List<SaldoVerif>> call, Response<List<SaldoVerif>> response) {
                        if (response.isSuccessful()){
                            view.onSuccess(response.body());
                        }else {
                            view.onError();
                        }
                        view.hideLoading();
                    }

                    @Override
                    public void onFailure(Call<List<SaldoVerif>> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }
}
