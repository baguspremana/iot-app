package com.example.user_pc.iotapp.admin.permintaanverif;

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
import com.example.user_pc.iotapp.admin.permintaanverif.detailpermintaanverif.DetailPermintaanActivity;
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.model.PermintaanVerif;
import com.example.user_pc.iotapp.model.PermintaanVerifResponse;

import java.util.List;

public class FragmentPermintaanVerif extends Fragment implements PermintaanVerifAdapter.OnClickListener, PermintaanVerifView {
    private PermintaanVerifAdapter adapter;
    private PermintaanVerifPresenter presenter;
    private List<PermintaanVerifResponse> permintaanVerifList;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permintaan_verif, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_permintaan_verif);
        textView = view.findViewById(R.id.tv_permintaan_kosong);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Now Loading");
        presenter = new PermintaanVerifPresenter(this, ApiClient.getService(getContext()));
        presenter.showList();
    }

    @Override
    public void onClickAdapter(int position) {
        PermintaanVerifResponse permintaanVerif = permintaanVerifList.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailPermintaanActivity.KEY_SALDO, permintaanVerif);
        Intent intent = new Intent(getContext(), DetailPermintaanActivity.class);
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
    public void onSuccess(List<PermintaanVerifResponse> permintaanVerifList) {
        if (permintaanVerifList.isEmpty()){
            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            this.permintaanVerifList = permintaanVerifList;
            adapter = new PermintaanVerifAdapter(getContext(), permintaanVerifList);
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
