package com.roisoftstudio.motogpfantasy.ui.lastresults;

import com.roisoftstudio.motogpfantasy.domain.model.RaceResult;
import com.roisoftstudio.motogpfantasy.domain.service.RaceResultsService;

import java.util.List;

import javax.inject.Inject;

import static com.roisoftstudio.motogpfantasy.domain.model.Category.MOTOGP;

public class LastResultsPresenter {

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
        raceResultsService.getCurrentResults(new LastResultsCallback(view), MOTOGP);
    }


    public interface View {
        void showResults(List<RaceResult> results);
        void showError(String message);
    }
}
