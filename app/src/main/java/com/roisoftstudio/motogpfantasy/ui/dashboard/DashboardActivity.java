package com.roisoftstudio.motogpfantasy.ui.dashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.roisoftstudio.motogpfantasy.infrastructure.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.service.ScoresService;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.GetScoresCallback;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsActivity;
import com.roisoftstudio.motogpfantasy.ui.myselection.MySelectionActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    @Inject
    ScoresService scoresService;

    @BindView(R.id.scores_container)
    LinearLayout scoresItemContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MotoGPApplication.component().inject(this);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        initScores();
    }

    private void initScores() {
        scoresService.getAll(new GetScoresCallback(scoresItemContainer, this, findViewById(android.R.id.content)));
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
