package com.example.user_pc.iotapp.admin.permintaanverif;

import com.example.user_pc.iotapp.model.PermintaanVerif;
import com.example.user_pc.iotapp.model.PermintaanVerifResponse;

import java.util.List;

public interface PermintaanVerifView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<PermintaanVerifResponse> permintaanVerifList);
    void onError();
    void onFailure(Throwable t);
}
