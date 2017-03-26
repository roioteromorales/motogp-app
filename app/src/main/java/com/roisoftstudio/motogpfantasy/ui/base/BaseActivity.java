package com.roisoftstudio.motogpfantasy.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        createLayout();
        bindViews();
        initializeViews(savedInstanceState);
        initializePresenter();
    }
    protected abstract void injectDependencies();
    protected void createLayout() {
        setContentView(getLayoutResource());
    }
    private void bindViews() {
        ButterKnife.bind(this);
    }
    protected abstract void initializeViews(Bundle savedInstanceState);
    protected abstract void initializePresenter();
    @LayoutRes
    protected abstract int getLayoutResource();
}
