package com.roisoftstudio.motogpfantasy.ui.myselection;

import com.roisoftstudio.motogpfantasy.domain.model.Selection;
import com.roisoftstudio.motogpfantasy.domain.service.MySelectionService;

import javax.inject.Inject;

import static com.roisoftstudio.motogpfantasy.domain.model.Category.MOTOGP;

public class MySelectionPresenter {

    private View view;

    private MySelectionService mySelectionService;

    @Inject
    public MySelectionPresenter(MySelectionService mySelectionService) {
        this.mySelectionService = mySelectionService;
    }

    public void setView(MySelectionPresenter.View view) {
        this.view = view;
    }

    public void onInitialize() {
        mySelectionService.getMySelection(new MySelectionCallback(view), MOTOGP);
    }


    public interface View {
        void showMySelection(Selection selection);
        void showError(String message);
    }
}
