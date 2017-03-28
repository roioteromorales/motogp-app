package com.roisoftstudio.motogpfantasy.ui.myselection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.MySelection;
import com.roisoftstudio.motogpfantasy.infrastructure.Injector;
import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;
import com.roisoftstudio.motogpfantasy.ui.login.LoginPresenter;

import javax.inject.Inject;

public class MySelectionActivity extends BaseActivity implements MySelectionPresenter.View {
    @Inject
    MySelectionPresenter mySelectionPresenter;

    public static Intent createIntent(Context context) {
        return new Intent(context, MySelectionActivity.class);
    }

    @Override
    protected void injectDependencies() {
        Injector.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
    }

    @Override
    protected void initializePresenter() {
        mySelectionPresenter.setView(this);
        mySelectionPresenter.onInitialize();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_my_selection;
    }

    @Override
    public void showMySelection(MySelection mySelection) {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
