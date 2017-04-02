package com.roisoftstudio.motogpfantasy.ui.myselection;

import android.util.Log;

import com.roisoftstudio.motogpfantasy.domain.model.Selection;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveSelectionCallback implements Callback<Selection> {
    private static final String TAG = "SaveSelectionCallback";

    private SelectionPresenter.View view;

    public SaveSelectionCallback(SelectionPresenter.View view) {
        this.view = view;
    }

    @Override
    public void onResponse(Call<Selection> call, Response<Selection> response) {
        String message = "Selection created Success";
        if (response.isSuccessful()) {
            Selection selection = response.body();
            view.showMySelection(selection);
        } else {
            try {
                message = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        view.showError(message);
    }

    @Override
    public void onFailure(Call<Selection> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        view.showError(t.getMessage());
    }
}
