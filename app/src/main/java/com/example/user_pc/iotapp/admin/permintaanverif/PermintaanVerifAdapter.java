package com.example.user_pc.iotapp.admin.permintaanverif;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.helper.DateFormated;
import com.example.user_pc.iotapp.model.PermintaanVerif;
import com.example.user_pc.iotapp.model.PermintaanVerifResponse;

import java.util.List;

public class PermintaanVerifAdapter extends RecyclerView.Adapter<PermintaanVerifAdapter.ViewHolder> {
    private Context context;
    private OnClickListener OnClickListener;
    private List<PermintaanVerifResponse> permintaanVerifList;

    public interface OnClickListener{
        void onClickAdapter(int position);
    }

    public PermintaanVerifAdapter(Context context, List<PermintaanVerifResponse> permintaanVerifList) {
        this.context = context;
        this.permintaanVerifList = permintaanVerifList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_permintaan_verif, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PermintaanVerifResponse permintaanVerif = permintaanVerifList.get(i);
        viewHolder.bind(permintaanVerif);
    }

    @Override
    public int getItemCount() {
        return permintaanVerifList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTanggal, tvRek;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_rubbish_permintaan);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal_permintaan);
            tvRek = itemView.findViewById(R.id.tv_rek_number);
            if (OnClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OnClickListener.onClickAdapter(getAdapterPosition());
                    }
                });
            }
        }

        public void bind(PermintaanVerifResponse permintaanVerif) {
            String tanggal = DateFormated.setPretty(permintaanVerif.getCreatedAt());
            tvName.setText(permintaanVerif.getRubbishName());
            tvRek.setText(permintaanVerif.getRekNumber());
            tvTanggal.setText(tanggal);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.OnClickListener = onClickListener;
    }
}
