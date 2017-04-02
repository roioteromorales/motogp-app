package com.roisoftstudio.motogpfantasy.domain.service;

import com.roisoftstudio.motogpfantasy.data.api.SelectionApi;
import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.domain.model.Selection;
import com.roisoftstudio.motogpfantasy.ui.myselection.GetSelectionCallback;
import com.roisoftstudio.motogpfantasy.ui.myselection.SaveSelectionCallback;

import javax.inject.Inject;

public class SelectionService {
    private final SelectionApi selectionApi;

    @Inject
    public SelectionService(SelectionApi selectionApi) {
        this.selectionApi = selectionApi;
    }

    public void getMySelection(GetSelectionCallback getSelectionCallback, Category category) {
        selectionApi.getMySelection(category).enqueue(getSelectionCallback);
    }

    public void saveMySelection(SaveSelectionCallback getSelectionCallback, Selection selection, Category category) {
        selectionApi.saveMySelection(selection, category).enqueue(getSelectionCallback);
    }

}
