package com.example.user_pc.iotapp.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.auth.LoginActivity;
import com.example.user_pc.iotapp.helper.CurrencyFormated;
import com.example.user_pc.iotapp.helper.PreferencesHelper;
import com.example.user_pc.iotapp.model.Profile;
import com.example.user_pc.iotapp.model.RekeningResponse;
import com.example.user_pc.iotapp.model.TotalSaldo;
import com.example.user_pc.iotapp.user.detailsaldo.DetailSaldoUserActivity;
import com.example.user_pc.iotapp.user.profile.ProfileUserActivity;
import com.example.user_pc.iotapp.user.saldouser.SaldoAdapter;
import com.example.user_pc.iotapp.user.saldouser.SaldoPresenter;
import com.example.user_pc.iotapp.user.saldouser.SaldoView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity implements View.OnClickListener, SaldoAdapter.OnClickListener, SaldoView {
    private ImageView ivLogout;
    private CircleImageView ivProfile;
    private PreferencesHelper preferencesHelper;
    private List<RekeningResponse> rekeningUserList;
    private RecyclerView recyclerView;
    private SaldoAdapter adapter;
    private SaldoPresenter presenter;
    private ProgressDialog progressDialog;
    private TextView textView;
    private TotalSaldo totalSaldo;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().hide();
        init();
        presenter.showSaldo();
        progressDialog.setMessage("Now Loading");
        showTotalSaldo();
        showProfile();
    }

    private void showProfile() {
        ApiClient.getService(this)
                .showProfile()
                .enqueue(new Callback<Profile>() {
                    @Override
                    public void onResponse(Call<Profile> call, Response<Profile> response) {
                        if (response.isSuccessful()){
                            profile = response.body();
                            if (profile.getFcmToken()==null){
                                saveFCM(profile.getId(), preferencesHelper.getFCMToken());
                            }
                        }else {
                            Toast.makeText(UserActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        Toast.makeText(UserActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveFCM(int id, String fcmToken) {
        ApiClient.getService(this)
                .saveFCM(id, fcmToken)
                .enqueue(new Callback<com.example.user_pc.iotapp.model.Response>() {
                    @Override
                    public void onResponse(Call<com.example.user_pc.iotapp.model.Response> call, Response<com.example.user_pc.iotapp.model.Response> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(UserActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(UserActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<com.example.user_pc.iotapp.model.Response> call, Throwable t) {
                        Toast.makeText(UserActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showTotalSaldo() {
        ApiClient.getService(this)
                .showTotal()
                .enqueue(new Callback<TotalSaldo>() {
                    @Override
                    public void onResponse(Call<TotalSaldo> call, Response<TotalSaldo> response) {
                        if (response.isSuccessful()){
                            totalSaldo = response.body();
                            String total = CurrencyFormated.toRupiah(Integer.parseInt(totalSaldo.getTotalSaldo()));
                            textView.setText(total);
                        }else {
                            Toast.makeText(UserActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TotalSaldo> call, Throwable t) {
                        Toast.makeText(UserActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void init() {
        preferencesHelper = new PreferencesHelper(this);
        presenter = new SaldoPresenter(this, ApiClient.getService(this));
        progressDialog = new ProgressDialog(this);
        ivLogout = findViewById(R.id.iv_logout);
        ivProfile = findViewById(R.id.iv_profile_user);
        recyclerView = findViewById(R.id.rv_setoran);
        textView = findViewById(R.id.tv_total_saldo);
        ivLogout.setOnClickListener(this);
        ivProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_logout:
                preferencesHelper.logout();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_profile_user:
                Intent intent1 = new Intent(this, ProfileUserActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onClickAdapter(int position) {
        RekeningResponse rekeningUser = rekeningUserList.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailSaldoUserActivity.KEY_SALDO, rekeningUser);
        Intent intent = new Intent(this, DetailSaldoUserActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void onSuccess(List<RekeningResponse> rekeningUserList) {
        this.rekeningUserList = rekeningUserList;
        adapter = new SaldoAdapter(this, rekeningUserList);
        adapter.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Response Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
