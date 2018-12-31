package com.example.user_pc.iotapp.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.model.User;

public class RegisterActivity extends AppCompatActivity implements AuthView, View.OnClickListener {
    private Button btnRegis;
    private EditText etName, etEmail, etPassword;
    private AuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        init();
    }

    private void init() {
        presenter = new AuthPresenter(this, ApiClient.getService(this));
        etName = findViewById(R.id.et_nama_register);
        etEmail = findViewById(R.id.et_email_register);
        etPassword = findViewById(R.id.et_password_register);
        btnRegis = findViewById(R.id.btn_regis);
        btnRegis.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_regis:
                register();
                break;
        }
    }

    private void register() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (validate(name, email, password)){
            presenter.register(name, email, password);
        }
    }

    public boolean validate(String name, String email, String password){
        if (name.equals("")){
            etName.setError("Field Nama Tidak Boleh Kosong");
            return false;
        }

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
        startActivity(new Intent(this, LoginActivity.class));
        finish();
        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
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
