package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.ScoresApi;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardScoresCallback;

import javax.inject.Inject;

public class ScoresService {

    private final ScoresApi scoresApi;

    @Inject
    public ScoresService(ScoresApi scoresApi) {
        this.scoresApi = scoresApi;
    }


    public void getAll(DashboardScoresCallback dashboardScoresCallback) {
        scoresApi.getAll().enqueue(dashboardScoresCallback);
    }
}
