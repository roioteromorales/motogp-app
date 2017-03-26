package com.roisoftstudio.motogpfantasy.ui.lastresults.results;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.RaceResult;
import com.roisoftstudio.motogpfantasy.domain.model.Score;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RaceResultsRowItemView extends FrameLayout {

    @BindView(R.id.race_result_row_number) TextView raceResultNumberTextView;
    @BindView(R.id.race_result_row_rider) TextView raceResultRiderTextView;
    @BindView(R.id.race_result_row_time) TextView raceResultTimeTextView;

    public RaceResultsRowItemView(@NonNull Context context) {
        this(context, null);
    }

    public RaceResultsRowItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RaceResultsRowItemView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.race_result_row_list_item_view, this, true);
        ButterKnife.bind(this);
    }

    public void fillWith(RaceResult raceResult) {
        raceResultNumberTextView.setText(String.valueOf(raceResult.getPosition()));
        raceResultRiderTextView.setText(raceResult.getRider());
        raceResultTimeTextView.setText(String.valueOf(raceResult.getTime()));
    }
}
