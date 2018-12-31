package com.example.user_pc.iotapp.user.profile;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.helper.PreferencesHelper;
import com.example.user_pc.iotapp.model.RekNumber;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileUserActivity extends AppCompatActivity {
    private PreferencesHelper preferencesHelper;
    private TextView tvName, tvEmail, tvRek;
    private ProgressDialog progressDialog;
    private RekNumber rekNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        getSupportActionBar().hide();
        init();
        setView();
        showRek();
    }

    private void showRek() {
        progressDialog.show();
        ApiClient.getService(this)
                .showRekNumber()
                .enqueue(new Callback<RekNumber>() {
                    @Override
                    public void onResponse(Call<RekNumber> call, Response<RekNumber> response) {
                        if (response.isSuccessful()){
                            rekNumber = response.body();
                            tvRek.setText(rekNumber.getRekNumber());
                        }else {
                            Toast.makeText(ProfileUserActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.hide();
                    }

                    @Override
                    public void onFailure(Call<RekNumber> call, Throwable t) {
                        Toast.makeText(ProfileUserActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setView() {
        tvName.setText(preferencesHelper.getName());
        tvEmail.setText(preferencesHelper.getEmail());
    }

    private void init() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Now Loading");
        preferencesHelper = new PreferencesHelper(this);
        tvName = findViewById(R.id.tv_name_user);
        tvEmail = findViewById(R.id.tv_email);
        tvRek = findViewById(R.id.tv_rek);
    }
}
