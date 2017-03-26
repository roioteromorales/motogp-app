package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.GrandPrixApi;
import com.roisoftstudio.motogpfantasy.ui.GetGrandPrixCallback;

import javax.inject.Inject;

public class GrandPrixService {

    private final GrandPrixApi grandPrixApi;

    @Inject
    public GrandPrixService(GrandPrixApi grandPrixApi) {
        this.grandPrixApi = grandPrixApi;
    }


    public void list(GetGrandPrixCallback getGrandPrixCallback, String year) {
        grandPrixApi.list(year).enqueue(getGrandPrixCallback);
    }
}
