package com.roisoftstudio.motogpfantasy.ui.start;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roisoftstudio.motogpfantasy.infrastructure.Injector;
import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardActivity;
import com.roisoftstudio.motogpfantasy.ui.login.LoginActivity;

import javax.inject.Inject;

public class StartActivity extends BaseActivity implements StartPresenter.View{

    @Inject
    StartPresenter presenter;

    @Override
    protected void injectDependencies() {
        Injector.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initializePresenter() {
        presenter.setView(this);
        presenter.onInitialize();
    }
    @Override
    protected void createLayout() {
       // setContentView(null);
    }
    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    public void redirectToLogin() {
        startActivity(LoginActivity.createIntent(this));
        finish();
    }

    @Override
    public void redirectToDashboard() {
        startActivity(DashboardActivity.createIntent(this));
        finish();
    }
}
