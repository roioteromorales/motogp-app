package com.roisoftstudio.motogpfantasy.ui.dashboard;

import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.domain.service.ScoresService;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.GetScoresCallback;

import java.util.List;

import javax.inject.Inject;

public class DashboardPresenter {

    private View view;
    private final ScoresService scoresService;

    @Inject
    public DashboardPresenter(ScoresService scoresService) {
        this.scoresService = scoresService;
    }

    public void onInitialize(android.view.View contentView) {
        scoresService.getAll(new GetScoresCallback(view, contentView));
    }

    public void setView(DashboardPresenter.View view) {
        this.view = view;
    }

    public interface View {
        void showScores(List<Score> scores);
    }
}
