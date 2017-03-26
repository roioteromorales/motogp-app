package com.roisoftstudio.motogpfantasy.ui.dashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.ScoreRowItemView;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsActivity;
import com.roisoftstudio.motogpfantasy.ui.myselection.MySelectionActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity implements DashboardPresenter.View  {

    @Inject DashboardPresenter dashboardPresenter;
    @BindView(R.id.scores_container) LinearLayout scoresItemContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MotoGPApplication.component().inject(this);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        initializePresenter();
    }

    protected void initializePresenter() {
        dashboardPresenter.setView(this);
        dashboardPresenter.onInitialize(findViewById(android.R.id.content));
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
