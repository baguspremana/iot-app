package com.example.user_pc.iotapp.admin.listsudahverif;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.admin.listsudahverif.detailsudahverif.DetailSudahVerifActivity;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.model.SaldoVerif;
import com.example.user_pc.iotapp.model.SaldoVerifResponse;

import java.util.List;

public class FragmentListVerif extends Fragment implements ListVerifAdapter.OnClickListener, ListVerifView {
    private ListVerifPresenter presenter;
    private ListVerifAdapter adapter;
    private List<SaldoVerif> saldoVerifResponseList;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_verif, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_list_verif);
        textView = view.findViewById(R.id.tv_verif_kosong);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Now Loading");
        presenter = new ListVerifPresenter(this, ApiClient.getService(getContext()));
        presenter.showVerif();
    }

    @Override
    public void onClickAdapter(int position) {
        SaldoVerif saldoVerifResponse = saldoVerifResponseList.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailSudahVerifActivity.KEY_SALDO, saldoVerifResponse);
        Intent intent = new Intent(getContext(), DetailSudahVerifActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void onSuccess(List<SaldoVerif> saldoVerifResponseList) {
        if (saldoVerifResponseList.isEmpty()){
            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            this.saldoVerifResponseList = saldoVerifResponseList;
            adapter = new ListVerifAdapter(getContext(), saldoVerifResponseList);
            adapter.setOnClickListener(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "Response Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }
}
