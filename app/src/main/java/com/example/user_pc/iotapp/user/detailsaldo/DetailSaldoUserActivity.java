package com.example.user_pc.iotapp.user.detailsaldo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.helper.CurrencyFormated;
import com.example.user_pc.iotapp.helper.DateFormated;
import com.example.user_pc.iotapp.model.RekeningResponse;
import com.example.user_pc.iotapp.model.RekeningUser;

public class DetailSaldoUserActivity extends AppCompatActivity {
    public static final String KEY_SALDO = "rekeningUser";
    private TextView tvName, tvBerat, tvHarga, tvTotal, tvUpdated, tvStatus;
    private RekeningResponse rekeningUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_saldo_user);

        getSupportActionBar().hide();
        init();
        setView();
    }

    private void setView() {
        String harga = CurrencyFormated.toRupiah(Integer.parseInt(rekeningUser.getRubbishPrice()));
        String total;
        if (rekeningUser.getBalance() == null){
            total = CurrencyFormated.toRupiah(0);
        }else {
            total = CurrencyFormated.toRupiah(Integer.parseInt(rekeningUser.getBalance()));
        }
        String tanggal = DateFormated.setDate(rekeningUser.getUpdatedAt());
        String satuan = " gram";
        tvName.setText(rekeningUser.getName());
        tvBerat.setText(rekeningUser.getWeight()+satuan);
        tvHarga.setText(harga);
        tvTotal.setText(total);
        tvUpdated.setText(tanggal);
        if (Integer.parseInt(rekeningUser.getStatus())==0){
            tvStatus.setText("Belum Terverifikasi");
        }else {
            tvStatus.setText("Terverifikasi");
        }
    }

    private void init() {
        rekeningUser = getIntent().getParcelableExtra(KEY_SALDO);
        tvName = findViewById(R.id.tv_detail_name_rubbish);
        tvBerat = findViewById(R.id.tv_berat);
        tvHarga = findViewById(R.id.tv_harga_satuan);
        tvTotal = findViewById(R.id.tv_total_jual);
        tvUpdated = findViewById(R.id.tv_updated);
        tvStatus = findViewById(R.id.tv_status);
    }
}
