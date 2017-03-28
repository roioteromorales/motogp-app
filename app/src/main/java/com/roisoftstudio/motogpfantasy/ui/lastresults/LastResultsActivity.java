package com.roisoftstudio.motogpfantasy.ui.lastresults;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.RaceResult;
import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.infrastructure.Injector;
import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.ScoreRowItemView;
import com.roisoftstudio.motogpfantasy.ui.lastresults.results.RaceResultsRowItemView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class LastResultsActivity extends BaseActivity implements LastResultsPresenter.View{
    @BindView(R.id.last_results_container)
    LinearLayout lastResultsLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    LastResultsPresenter lastResultsPresenter;

    public static Intent createIntent(Context context) {
        return new Intent(context, LastResultsActivity.class);
    }

    @Override
    protected void injectDependencies() {
        Injector.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
        toolbar.setTitle(getString(R.string.last_results_activity_title));
    }

    @Override
    protected void initializePresenter() {
        lastResultsPresenter.setView(this);
        lastResultsPresenter.onInitialize();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_last_results;
    }

    @Override
    public void showResults(List<RaceResult> results) {
        for (RaceResult result : results) {
            lastResultsLayout.addView(createRaceResultView(result));
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    private RaceResultsRowItemView createRaceResultView(RaceResult score) {
        RaceResultsRowItemView raceResultsRowItemView = new RaceResultsRowItemView(this);
        raceResultsRowItemView.fillWith(score);
        return raceResultsRowItemView;
    }
}
