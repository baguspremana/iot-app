package com.example.user_pc.iotapp.admin.listsaldouser;

import android.app.ProgressDialog;
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
import com.example.user_pc.iotapp.api.ApiClient;
import com.example.user_pc.iotapp.model.TotalSaldoUser;

import java.util.List;

public class FragmentSaldoUser extends Fragment implements SaldoUserView{
    private SaldoUserAdapter adapter;
    private SaldoUserPresenter presenter;
    private List<TotalSaldoUser> totalSaldoUserList;
    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saldo_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_saldo_user);
        textView = view.findViewById(R.id.tv_saldo_kosong);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Now Loading");
        presenter = new SaldoUserPresenter(this, ApiClient.getService(getContext()));
        presenter.showSaldoUser();
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
    public void onSuccess(List<TotalSaldoUser> totalSaldoUserList) {
        if (totalSaldoUserList.isEmpty()){
            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            this.totalSaldoUserList = totalSaldoUserList;
            adapter = new SaldoUserAdapter(getContext(), totalSaldoUserList);
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
