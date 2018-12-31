package com.example.user_pc.iotapp.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.admin.AdminActivity;
import com.example.user_pc.iotapp.user.UserActivity;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.helper.ConstantURL;
import com.example.user_pc.iotapp.helper.PreferencesHelper;
import com.example.user_pc.iotapp.model.User;

public class LoginActivity extends AppCompatActivity implements AuthView, View.OnClickListener {
    private TextView tvRegister;
    private Button btnLogin;
    private EditText etEmail, etPassword;
    private PreferencesHelper preferencesHelper;
    private AuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        init();
    }

    private void init() {
        preferencesHelper = new PreferencesHelper(this);
        presenter = new AuthPresenter(this, ApiClient.getService(this));
        etEmail = findViewById(R.id.et_email_login);
        etPassword = findViewById(R.id.et_password_login);
        tvRegister = findViewById(R.id.tv_register);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (validate(email, password)){
            presenter.login(email, password);
        }
    }

    public boolean validate(String email, String password){
        if (email.equals("")){
            etEmail.setError("Field Email Tidak Boleh Kosong");
            return false;
        }

        if (password.equals("")){
            etPassword.setError("Field Password Tidak Boleh Kosong");
            return false;
        }

        return true;
    }

    @Override
    public void onSuccess(User user) {
        preferencesHelper.setUserLogin(user);
        if (user.getPermission()==ConstantURL.Permission.USER){
            startActivity(new Intent(this, UserActivity.class));
        }else if (user.getPermission()==ConstantURL.Permission.ADMIN){
            startActivity(new Intent(this, AdminActivity.class));
        }
        finish();
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
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
