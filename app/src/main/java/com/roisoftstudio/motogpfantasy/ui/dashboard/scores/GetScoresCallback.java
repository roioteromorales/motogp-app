package com.roisoftstudio.motogpfantasy.ui.dashboard.scores;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.ui.dashboard.scores.ScoreRowItemView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetScoresCallback implements Callback<List<Score>> {
    private static final String TAG = "GetScoresCallback";

    private LinearLayout scoresItemContainer;
    private Context context;
    private View view;

    public GetScoresCallback(LinearLayout scoresItemContainer, Context context, View view) {
        this.scoresItemContainer = scoresItemContainer;
        this.context = context;
        this.view = view;
    }

    @Override
    public void onResponse(Call<List<Score>> call, Response<List<Score>> response) {
        String message = "GetScoresCallback - Success";
        if (response.isSuccessful()) {
            createScores(response.body());
        } else {
            try {
                message = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private void createScores(List<Score> scores) {
        for (Score score : scores) {
            scoresItemContainer.addView(createScoreRowItemView(score));
        }
    }

    private ScoreRowItemView createScoreRowItemView(Score score) {
        ScoreRowItemView scoreRowItemView = new ScoreRowItemView(context);
        scoreRowItemView.fillWith(score);
        return scoreRowItemView;
    }

    @Override
    public void onFailure(Call<List<Score>> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        Snackbar.make(view, "Error: " + t.getMessage(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
