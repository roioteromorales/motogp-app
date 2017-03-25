package com.roisoftstudio.motogpfantasy.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.roisoftstudio.motogpfantasy.MotoGPApplication;
import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.domain.service.GrandPrixService;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Inject
    GrandPrixService grandPrixService;

    @BindView(R.id.scores_container) LinearLayout scoresItemContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MotoGPApplication.component().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        grandPrixService.list(new GetGrandPrixCallback(findViewById(android.R.id.content)), "2017");
        initScores();
    }

    private void initScores() {
        List<Score> scores = createScores();
        for (Score score : scores) {
            scoresItemContainer.addView(createScoreRowItemView(score));
        }
    }

    private ScoreRowItemView createScoreRowItemView(Score score) {
        ScoreRowItemView scoreRowItemView = new ScoreRowItemView(this);
        scoreRowItemView.fillWith(score);
        return scoreRowItemView;
    }

    private List<Score> createScores() {
        return asList(
                new Score(1, "Magda", 493),
                new Score(2, "Moldes", 456),
                new Score(3, "Roi", 152),
                new Score(4, "Mauro", 36)
        );
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
