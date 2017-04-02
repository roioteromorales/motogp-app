package com.roisoftstudio.motogpfantasy.ui.myselection;

import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.domain.model.Selection;
import com.roisoftstudio.motogpfantasy.domain.service.SelectionService;

import javax.inject.Inject;

public class SelectionPresenter {

    private View view;

    private SelectionService selectionService;

    @Inject
    public SelectionPresenter(SelectionService selectionService) {
        this.selectionService = selectionService;
    }

    public void setView(SelectionPresenter.View view) {
        this.view = view;
    }

    public void onInitialize(Category category) {
        selectionService.getMySelection(new GetSelectionCallback(view), category);
    }

    public void save(Selection selection, Category category) {
        selectionService.saveMySelection(new SaveSelectionCallback(view), selection, category);
    }

    public interface View {
        void showMySelection(Selection selection);

        void showError(String message);
    }
}
