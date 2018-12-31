package com.example.user_pc.iotapp.user.saldouser;

import com.example.user_pc.iotapp.model.RekeningResponse;

import java.util.List;

public interface SaldoView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<RekeningResponse> rekeningUserList);
    void onError();
    void onFailure(Throwable t);
}
