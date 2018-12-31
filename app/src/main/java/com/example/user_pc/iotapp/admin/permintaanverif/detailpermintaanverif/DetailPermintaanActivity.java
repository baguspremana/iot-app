package com.example.user_pc.iotapp.admin.permintaanverif.detailpermintaanverif;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.admin.AdminActivity;
import com.example.user_pc.iotapp.admin.permintaanverif.FragmentPermintaanVerif;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.helper.CurrencyFormated;
import com.example.user_pc.iotapp.helper.DateFormated;
import com.example.user_pc.iotapp.model.PermintaanVerif;
import com.example.user_pc.iotapp.model.PermintaanVerifResponse;
import com.example.user_pc.iotapp.model.Response;

public class DetailPermintaanActivity extends AppCompatActivity implements DetailPermintaanView, View.OnClickListener {
    public static final String KEY_SALDO = "permintaanVerif";
    private PermintaanVerifResponse permintaanVerif;
    private TextView tvName, tvRek, tvBarang, tvBerat, tvHarga, tvTanggal;
    private DetailPermintaanPresenter presenter;
    private Button btnVerif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_permintaan);

        getSupportActionBar().hide();
        init();
        setView();
    }

    private void setView() {
        String harga = CurrencyFormated.toRupiah(Integer.parseInt(permintaanVerif.getRubbishPrice()));
        String tanggal = DateFormated.setDate(permintaanVerif.getCreatedAt());
        String berat = String.valueOf(permintaanVerif.getWeight());

        tvName.setText(permintaanVerif.getName());
        tvRek.setText(permintaanVerif.getRekNumber());
        tvBarang.setText(permintaanVerif.getRubbishName());
        tvBerat.setText(berat+" gram");
        tvHarga.setText(harga);
        tvTanggal.setText(tanggal);
    }

    private void init() {
        permintaanVerif = getIntent().getParcelableExtra(KEY_SALDO);
        presenter = new DetailPermintaanPresenter(this, ApiClient.getService(this));
        tvName = findViewById(R.id.tv_detail_name_member);
        tvRek = findViewById(R.id.tv_detail_rek_number);
        tvBarang = findViewById(R.id.tv_detail_name_rubbish_verif);
        tvBerat = findViewById(R.id.tv_detail_berat);
        tvHarga = findViewById(R.id.tv_detail_harga_satuan);
        tvTanggal = findViewById(R.id.tv_detail_updated);
        btnVerif = findViewById(R.id.btnVerif);
        btnVerif.setOnClickListener(this);
    }

    @Override
    public void onSuccess(Response response) {
        Intent intent = new Intent(this, AdminActivity.class);
        intent.putExtra("verifikasi", FragmentPermintaanVerif.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Response Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnVerif:
                verifikasi();
                break;
        }
    }

    private void verifikasi() {
        Button btnDialog;

        AlertDialog.Builder dialog;
        dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_verif, null);

        btnDialog = dialogView.findViewById(R.id.btnDialogVerif);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.verifikasi(permintaanVerif.getId());
            }
        });

        dialog.setView(dialogView);
        dialog.show();
    }
}
