package com.example.user_pc.iotapp.admin.listsudahverif.detailsudahverif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.helper.CurrencyFormated;
import com.example.user_pc.iotapp.helper.DateFormated;
import com.example.user_pc.iotapp.model.SaldoVerif;
import com.example.user_pc.iotapp.model.SaldoVerifResponse;

public class DetailSudahVerifActivity extends AppCompatActivity {
    public static final String KEY_SALDO = "saldoVerifResponse";
    private SaldoVerif saldoVerifResponse;
    private TextView tvName, tvRek, tvBarang, tvBerat, tvTotal, tvTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sudah_verif);

        getSupportActionBar().hide();
        init();
        setView();
    }

    private void setView() {
        String harga = CurrencyFormated.toRupiah(Integer.parseInt(saldoVerifResponse.getBalance()));
        String tanggal = DateFormated.setDate(saldoVerifResponse.getUpdatedAt());
        String berat = saldoVerifResponse.getWeight();

        tvName.setText(saldoVerifResponse.getName());
        tvRek.setText(saldoVerifResponse.getRekNumber());
        tvBarang.setText(saldoVerifResponse.getRubbishName());
        tvBerat.setText(berat+" gram");
        tvTotal.setText(harga);
        tvTanggal.setText(tanggal);
    }

    private void init() {
        saldoVerifResponse = getIntent().getParcelableExtra(KEY_SALDO);
        tvName = findViewById(R.id.tv_detail_verif_name);
        tvRek = findViewById(R.id.tv_detail_verif_number);
        tvBarang = findViewById(R.id.tv_detail_verif_rubbish);
        tvBerat = findViewById(R.id.tv_detail_verif_berat);
        tvTotal = findViewById(R.id.tv_detail_verif_total_harga);
        tvTanggal = findViewById(R.id.tv_detail_verif_tanggal);
    }
}
