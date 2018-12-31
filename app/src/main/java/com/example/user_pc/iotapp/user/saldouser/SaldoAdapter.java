package com.example.user_pc.iotapp.user.saldouser;

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
import com.example.user_pc.iotapp.model.RekeningResponse;
import com.example.user_pc.iotapp.model.RekeningUser;

import java.util.List;

public class SaldoAdapter extends RecyclerView.Adapter<SaldoAdapter.ViewHolder> {
    private Context context;
    private OnClickListener OnClickListener;
    private List<RekeningResponse> rekeningUserList;

    public SaldoAdapter(Context context, List<RekeningResponse> rekeningUserList) {
        this.context = context;
        this.rekeningUserList = rekeningUserList;
    }

    public interface OnClickListener{
        void onClickAdapter(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_saldo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RekeningResponse rekeningUser = rekeningUserList.get(i);
        viewHolder.bind(rekeningUser);
    }

    @Override
    public int getItemCount() {
        return rekeningUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTanggal, tvBalance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_rubbish);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvBalance = itemView.findViewById(R.id.tv_balance);
            if (OnClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OnClickListener.onClickAdapter(getAdapterPosition());
                    }
                });
            }
        }

        public void bind(RekeningResponse rekeningUser) {
            String total;
            if (rekeningUser.getBalance() == null){
                total = CurrencyFormated.toRupiah(0);
            }else {
                total = CurrencyFormated.toRupiah(Integer.parseInt(rekeningUser.getBalance()));
            }
            String tanggal = DateFormated.setPretty(rekeningUser.getUpdatedAt());
            tvName.setText(rekeningUser.getName());
            tvTanggal.setText(tanggal);
            tvBalance.setText(total);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.OnClickListener = onClickListener;
    }
}
