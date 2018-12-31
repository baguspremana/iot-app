package com.example.user_pc.iotapp.admin.listsaldouser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.helper.CurrencyFormated;
import com.example.user_pc.iotapp.helper.DateFormated;
import com.example.user_pc.iotapp.model.TotalSaldoUser;

import java.util.List;

public class SaldoUserAdapter extends RecyclerView.Adapter<SaldoUserAdapter.ViewHolder> {
    private Context context;
    private List<TotalSaldoUser> totalSaldoUserList;

    public SaldoUserAdapter(Context context, List<TotalSaldoUser> totalSaldoUserList) {
        this.context = context;
        this.totalSaldoUserList = totalSaldoUserList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_saldo_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TotalSaldoUser totalSaldoUser = totalSaldoUserList.get(i);
        viewHolder.bind(totalSaldoUser);
    }

    @Override
    public int getItemCount() {
        return totalSaldoUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTotal, tvTanggal, tvRek;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_member);
            tvTotal = itemView.findViewById(R.id.tv_total_saldo_user);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal_updated_saldo);
            tvRek = itemView.findViewById(R.id.tv_rek_number_member);
        }

        public void bind(TotalSaldoUser totalSaldoUser) {
            String tanggal = DateFormated.setDate(totalSaldoUser.getUpdatedTerakhir());
            int totalSaldo;
            String total;
            if (totalSaldoUser.getTotalSaldo() != null){
                totalSaldo = Integer.valueOf(totalSaldoUser.getTotalSaldo());
            }else {
                totalSaldo = 0;
            }
            total  = CurrencyFormated.toRupiah(totalSaldo);
            tvName.setText(totalSaldoUser.getName());
            tvTanggal.setText(tanggal);
            tvTotal.setText(total);
            tvRek.setText(totalSaldoUser.getRekNumber());
        }
    }
}
