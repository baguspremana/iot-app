package com.example.user_pc.iotapp.admin.listsudahverif;

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
import com.example.user_pc.iotapp.model.SaldoVerif;
import com.example.user_pc.iotapp.model.SaldoVerifResponse;

import java.util.List;

public class ListVerifAdapter extends RecyclerView.Adapter<ListVerifAdapter.ViewHolder> {
    private Context context;
    private OnClickListener OnClickListener;
    private List<SaldoVerif> saldoVerifResponseList;

    public ListVerifAdapter(Context context, List<SaldoVerif> saldoVerifResponseList) {
        this.context = context;
        this.saldoVerifResponseList = saldoVerifResponseList;
    }

    public interface OnClickListener{
        void onClickAdapter(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_saldo_verif, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SaldoVerif saldoVerifResponse = saldoVerifResponseList.get(i);
        viewHolder.bind(saldoVerifResponse);
    }

    @Override
    public int getItemCount() {
        return saldoVerifResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTanggal, tvBalance, tvRek;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_rubbish_verif);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal_verif);
            tvBalance = itemView.findViewById(R.id.tv_balance_verif);
            tvRek = itemView.findViewById(R.id.tv_rek_number_verif);
            if (OnClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OnClickListener.onClickAdapter(getAdapterPosition());
                    }
                });
            }
        }

        public void bind(SaldoVerif saldoVerifResponse) {
            String tanggal = DateFormated.setPretty(saldoVerifResponse.getUpdatedAt());
            String balance = CurrencyFormated.toRupiah(Integer.parseInt(saldoVerifResponse.getBalance()));
            tvName.setText(saldoVerifResponse.getRubbishName());
            tvBalance.setText(balance);
            tvTanggal.setText(tanggal);
            tvRek.setText(saldoVerifResponse.getRekNumber());
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.OnClickListener = onClickListener;
    }
}
