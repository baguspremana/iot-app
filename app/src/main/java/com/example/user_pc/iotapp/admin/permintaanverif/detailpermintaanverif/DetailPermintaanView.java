package com.example.user_pc.iotapp.admin.permintaanverif.detailpermintaanverif;

import com.example.user_pc.iotapp.model.Response;

public interface DetailPermintaanView {
    void onSuccess(Response response);
    void onError();
    void onFailure(Throwable t);
}
