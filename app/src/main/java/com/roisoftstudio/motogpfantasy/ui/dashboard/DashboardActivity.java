package com.roisoftstudio.motogpfantasy.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.ScoreRowItemView;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsActivity;
import com.roisoftstudio.motogpfantasy.ui.myselection.MySelectionActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class DashboardActivity extends BaseActivity implements DashboardPresenter.View {

    @Inject
    DashboardPresenter dashboardPresenter;
    @BindView(R.id.scores_container)
    LinearLayout scoresItemContainer;

    public static Intent createIntent(Context context) {
        return new Intent(context, DashboardActivity.class);
    }

    @Override
    protected void injectDependencies() {
        MotoGPApplication.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {

    }

    protected void initializePresenter() {
        dashboardPresenter.setView(this);
        dashboardPresenter.onInitialize(findViewById(android.R.id.content));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_dashboard;
    }

    @Override
    public void showScores(List<Score> scores) {
        for (Score score : scores) {
            scoresItemContainer.addView(createScoreRowItemView(score));
        }
    }

    private ScoreRowItemView createScoreRowItemView(Score score) {
        ScoreRowItemView scoreRowItemView = new ScoreRowItemView(this);
        scoreRowItemView.fillWith(score);
        return scoreRowItemView;
    }

    @OnClick(R.id.last_results_button)
    public void onLastResultsButtonClick() {
        startActivity(LastResultsActivity.createIntent(this));
    }

    @OnClick(R.id.my_selection_button)
    public void onMySelectionButtonClick() {
        startActivity(MySelectionActivity.createIntent(this));
    }

}
