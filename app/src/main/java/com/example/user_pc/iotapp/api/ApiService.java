package com.example.user_pc.iotapp.api;

import com.example.user_pc.iotapp.model.PermintaanVerif;
import com.example.user_pc.iotapp.model.PermintaanVerifResponse;
import com.example.user_pc.iotapp.model.Profile;
import com.example.user_pc.iotapp.model.RekNumber;
import com.example.user_pc.iotapp.model.RekeningResponse;
import com.example.user_pc.iotapp.model.RekeningUser;
import com.example.user_pc.iotapp.model.Response;
import com.example.user_pc.iotapp.model.SaldoVerif;
import com.example.user_pc.iotapp.model.SaldoVerifResponse;
import com.example.user_pc.iotapp.model.TotalSaldo;
import com.example.user_pc.iotapp.model.TotalSaldoUser;
import com.example.user_pc.iotapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("login")
    Call<User> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<User> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("show/rekening")
    Call<List<RekeningResponse>> showSaldo();

    @GET("total/saldo")
    Call<TotalSaldo> showTotal();

    @GET("admin/show/rekening")
    Call<List<PermintaanVerifResponse>> showPermintaa();

    @GET("admin/show/verifikasi")
    Call<List<SaldoVerif>> showVerif();

    @GET("admin/show/saldo")
    Call<List<TotalSaldoUser>> showSaldoUser();

    @POST("admin/save/harga/{id}")
    Call<Response> verifikasi(
            @Path("id") int id
    );

    @GET("profile")
    Call<Profile> showProfile();

    @FormUrlEncoded
    @POST("user/save/fcm/{id}")
    Call<Response> saveFCM(
            @Path("id") int id,
            @Field("fcm_token") String fcm_token
    );

    @GET("rek")
    Call<RekNumber> showRekNumber();
}
