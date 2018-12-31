package com.example.user_pc.iotapp.admin.listsaldouser;

import com.example.user_pc.iotapp.model.TotalSaldoUser;

import java.util.List;

public interface SaldoUserView {
    void showLoading();
    void hideLoading();
    void onSuccess(List<TotalSaldoUser> totalSaldoUserList);
    void onError();
    void onFailure(Throwable t);
}
