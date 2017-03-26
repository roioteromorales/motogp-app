package com.roisoftstudio.motogpfantasy.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.data.persistance.AppPreferences;
import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class LoginActivity  extends BaseActivity implements LoginPresenter.View {
    @BindView(R.id.login_email) public EditText emailText;
    @BindView(R.id.login_password) public EditText passwordText;
    @Inject AppPreferences appPreferences;
    @Inject LoginPresenter loginPresenter;

    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void injectDependencies() {
        MotoGPApplication.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initializePresenter() {
        loginPresenter.setView(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login_button)
    public void onLoginClick() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        loginPresenter.onLoginClick(email, password);
    }

    @Override
    public void redirectToDashboard() {
        startActivity(DashboardActivity.createIntent(this));
        finish();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(findViewById(android.R.id.content), "Error: " + message, LENGTH_LONG).show();
    }
}
