package com.example.user_pc.iotapp.admin;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bigscreen.iconictabbar.view.IconicTab;
import com.bigscreen.iconictabbar.view.IconicTabBar;
import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.admin.listsaldouser.FragmentSaldoUser;
import com.example.user_pc.iotapp.admin.listsudahverif.FragmentListVerif;
import com.example.user_pc.iotapp.admin.permintaanverif.FragmentPermintaanVerif;
import com.example.user_pc.iotapp.admin.profile.FragmentProfileAdmin;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.helper.PreferencesHelper;
import com.example.user_pc.iotapp.model.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminActivity extends AppCompatActivity {
    private IconicTabBar iconicTabBar;
    private static final String TAG = AdminActivity.class.getSimpleName();
    private Profile profile;
    private PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        preferencesHelper = new PreferencesHelper(this);

        getSupportActionBar().hide();

        iconicTabBar = findViewById(R.id.bottom_navigation);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            if (extra.containsKey("verifikasi")){
                iconicTabBar.setSelectedTab(1);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_admin_container,
                        new FragmentListVerif()).commit();
            }
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_admin_container,
                    new FragmentPermintaanVerif()).commit();
        }


        initViews();
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
                            if (profile.getFcmToken() == null){
                                saveFCM(profile.getId(), preferencesHelper.getFCMToken());
                            }
                        }else {
                            Toast.makeText(AdminActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        Toast.makeText(AdminActivity.this, "Error", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(AdminActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(AdminActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<com.example.user_pc.iotapp.model.Response> call, Throwable t) {
                        Toast.makeText(AdminActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initViews() {
        iconicTabBar.setOnTabSelectedListener(new IconicTabBar.OnTabSelectedListener() {
            @Override
            public void onSelected(IconicTab tab, int position) {
                Log.d(TAG, "selected tab on= "+position);
                Fragment selectedUserFragment = null;
                int tabId = tab.getId();
                switch (tabId){
                    case R.id.nav_list:
                        selectedUserFragment = new FragmentPermintaanVerif();
                        break;
                    case R.id.nav_verif:
                        selectedUserFragment = new FragmentListVerif();
                        break;
                    case R.id.nav_saldo:
                        selectedUserFragment = new FragmentSaldoUser();
                        break;
                    case R.id.nav_profile:
                        selectedUserFragment = new FragmentProfileAdmin();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_admin_container,
                        selectedUserFragment).commit();
            }

            @Override
            public void onUnselected(IconicTab tab, int position) {
                Log.d(TAG, "unselected tab on= "+position);
            }
        });
    }
}
