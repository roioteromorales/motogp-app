package com.roisoftstudio.motogpfantasy.ui.lastresults;

import com.roisoftstudio.motogpfantasy.domain.model.RaceResult;
import com.roisoftstudio.motogpfantasy.domain.service.RaceResultsService;

import java.util.List;

import javax.inject.Inject;

public class LastResultsPresenter {

    private static final String MOTOGP_CATEGORY = "MOTOGP";
    private View view;
    private RaceResultsService raceResultsService;


    @Inject
    public LastResultsPresenter(RaceResultsService raceResultsService) {
        this.raceResultsService = raceResultsService;
    }

    public void setView(LastResultsPresenter.View view) {
        this.view = view;
    }

    public void onInitialize() {
        raceResultsService.getCurrentResults(new LastResultsCallback(view), MOTOGP_CATEGORY);
    }


    public interface View {
        void showResults(List<RaceResult> results);
        void showError(String message);
    }
}
