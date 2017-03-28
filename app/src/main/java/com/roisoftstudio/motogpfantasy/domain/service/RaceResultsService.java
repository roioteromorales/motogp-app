package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.RaceResultsApi;
import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsCallback;

import javax.inject.Inject;

public class RaceResultsService {
    private final RaceResultsApi raceResultsApi;

    @Inject
    public RaceResultsService(RaceResultsApi raceResultsApi) {
        this.raceResultsApi = raceResultsApi;
    }
    public void getCurrentResults(LastResultsCallback lastResultsCallback, Category category) {
        raceResultsApi.getRaceResults(category).enqueue(lastResultsCallback);
    }

}
