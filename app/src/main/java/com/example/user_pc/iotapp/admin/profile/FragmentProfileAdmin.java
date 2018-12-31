package com.example.user_pc.iotapp.admin.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user_pc.iotapp.R;
import com.example.user_pc.iotapp.auth.LoginActivity;
import com.example.user_pc.iotapp.helper.PreferencesHelper;

public class FragmentProfileAdmin extends Fragment implements View.OnClickListener{
    private PreferencesHelper preferencesHelper;
    private TextView tvName, tvEmail;
    private ImageView btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = view.findViewById(R.id.tv_name_admin);
        tvEmail = view.findViewById(R.id.tv_email_admin);
        btnLogout = view.findViewById(R.id.iv_logout_admin);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        preferencesHelper = new PreferencesHelper(getContext());
        showProfile();
        btnLogout.setOnClickListener(this);
    }

    private void showProfile() {
        tvName.setText(preferencesHelper.getName());
        tvEmail.setText(preferencesHelper.getEmail());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_logout_admin:
                preferencesHelper.logout();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
        }
    }
}
