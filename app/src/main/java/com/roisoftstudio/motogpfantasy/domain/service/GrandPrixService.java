package com.roisoftstudio.motogpfantasy.domain.service;

import android.view.View;

import com.roisoftstudio.motogpfantasy.datasource.api.GrandPrixApi;
import com.roisoftstudio.motogpfantasy.domain.model.GrandPrix;
import com.roisoftstudio.motogpfantasy.ui.GetGrandPrixCallback;

import java.io.IOException;

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
