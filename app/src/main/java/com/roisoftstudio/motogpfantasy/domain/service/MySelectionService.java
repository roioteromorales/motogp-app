package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.MySelectionApi;
import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.ui.myselection.MySelectionCallback;

import javax.inject.Inject;

public class MySelectionService {
    private final MySelectionApi mySelectionApi;

    @Inject
    public MySelectionService(MySelectionApi mySelectionApi) {
        this.mySelectionApi = mySelectionApi;
    }
    public void getMySelection(MySelectionCallback mySelectionCallback, Category category) {
        mySelectionApi.getMySelection(category).enqueue(mySelectionCallback);
    }

}
