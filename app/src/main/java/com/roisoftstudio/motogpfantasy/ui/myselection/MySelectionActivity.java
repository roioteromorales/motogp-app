package com.roisoftstudio.motogpfantasy.ui.myselection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.LapResult;
import com.roisoftstudio.motogpfantasy.domain.model.Selection;
import com.roisoftstudio.motogpfantasy.domain.model.rider.Rider;
import com.roisoftstudio.motogpfantasy.infrastructure.Injector;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class MySelectionActivity extends BaseActivity implements MySelectionPresenter.View {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.my_selection_first) TextView firstTv;
    @BindView(R.id.my_selection_second) TextView secondTv;
    @BindView(R.id.my_selection_third) TextView thirdTv;
    @BindView(R.id.my_selection_fastest_lap_time) TextView fastestLapTimeTv;
    @BindView(R.id.my_selection_fastest_lap_rider) TextView fastestLapRiderTv;

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
        toolbar.setTitle(getString(R.string.my_selection_activity_title));
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
    public void showMySelection(Selection selection) {
        Rider firstPosition = selection.getFirstPosition();
        Rider secondPosition = selection.getSecondPosition();
        Rider thirdPosition = selection.getThirdPosition();
        LapResult fastestLap = selection.getFastestLap();

        firstTv.setText(firstPosition.getName());
        secondTv.setText(secondPosition.getName());
        thirdTv.setText(thirdPosition.getName());
        fastestLapRiderTv.setText(fastestLap.getRider().getName());
        fastestLapTimeTv.setText(fastestLap.getTime());
    }


    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
