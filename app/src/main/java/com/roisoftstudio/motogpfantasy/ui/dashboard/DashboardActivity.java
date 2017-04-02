package com.roisoftstudio.motogpfantasy.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.infrastructure.Injector;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.ScoreRowItemView;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsActivity;
import com.roisoftstudio.motogpfantasy.ui.login.LoginActivity;
import com.roisoftstudio.motogpfantasy.ui.myselection.SelectionActivity;

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
        Injector.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void initializePresenter() {
        dashboardPresenter.setView(this);
        dashboardPresenter.onInitialize();
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

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logout() {
        startActivity(LoginActivity.createIntent(this));
        finish();
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
        startActivity(SelectionActivity.createIntent(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                dashboardPresenter.logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
