package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.ScoresApi;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.GetScoresCallback;

import javax.inject.Inject;

public class ScoresService {

    private final ScoresApi scoresApi;

    @Inject
    public ScoresService(ScoresApi scoresApi) {
        this.scoresApi = scoresApi;
    }


    public void getAll(GetScoresCallback getScoresCallback) {
        scoresApi.getAll().enqueue(getScoresCallback);
    }
}
