package com.roisoftstudio.motogpfantasy.ui.dashboard;

import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.domain.service.LoginService;
import com.roisoftstudio.motogpfantasy.domain.service.ScoresService;

import java.util.List;

import javax.inject.Inject;

public class DashboardPresenter {

    private View view;
    private final ScoresService scoresService;
    private final LoginService loginService;

    @Inject
    public DashboardPresenter(ScoresService scoresService, LoginService loginService) {
        this.scoresService = scoresService;
        this.loginService = loginService;
    }

    public void onInitialize() {
        scoresService.getAll(new DashboardScoresCallback(view));
    }

    public void setView(DashboardPresenter.View view) {
        this.view = view;
    }

    public void logout() {
        loginService.logout();
        view.logout();
    }

    public interface View {
        void showScores(List<Score> scores);
        void showError(String message);
        void logout();
    }
}
