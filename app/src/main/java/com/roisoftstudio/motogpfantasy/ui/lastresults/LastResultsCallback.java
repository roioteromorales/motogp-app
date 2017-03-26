package com.roisoftstudio.motogpfantasy.ui.lastresults;

import android.util.Log;

import com.roisoftstudio.motogpfantasy.domain.model.RaceResult;
import com.roisoftstudio.motogpfantasy.ui.lastresults.LastResultsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LastResultsCallback implements Callback<List<RaceResult>> {
    private static final String TAG = "LastResultsCallback";

    private LastResultsPresenter.View lastResultsView;

    public LastResultsCallback(LastResultsPresenter.View lastResultsView) {
        this.lastResultsView = lastResultsView;
    }

    @Override
    public void onResponse(Call<List<RaceResult>> call, Response<List<RaceResult>> response) {
        String message = "LastResultsCallback - Success";
        if (response.isSuccessful()) {
            lastResultsView.showResults(response.body());
        } else {
            try {
                message = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        lastResultsView.showError(message);
    }

    @Override
    public void onFailure(Call<List<RaceResult>> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        lastResultsView.showError(t.getMessage());
    }
}
