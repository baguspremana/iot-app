package com.example.user_pc.iotapp.admin.listsudahverif;

import com.example.user_pc.iotapp.model.SaldoVerif;
import com.example.user_pc.iotapp.model.SaldoVerifResponse;

import java.util.List;

public interface ListVerifView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<SaldoVerif> saldoVerifResponseList);
    void onError();
    void onFailure(Throwable t);
}
