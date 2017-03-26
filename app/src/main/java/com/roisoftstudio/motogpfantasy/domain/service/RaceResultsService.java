package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.RaceResultsApi;
import com.roisoftstudio.motogpfantasy.ui.lastresults.results.GetRaceResultsCallback;

import javax.inject.Inject;

public class RaceResultsService {
    private final RaceResultsApi raceResultsApi;

    @Inject
    public RaceResultsService(RaceResultsApi raceResultsApi) {
        this.raceResultsApi = raceResultsApi;
    }
    public void getCurrentResults(GetRaceResultsCallback getRaceResultsCallback, String category) {
        raceResultsApi.getRaceResults(category).enqueue(getRaceResultsCallback);
    }

}
