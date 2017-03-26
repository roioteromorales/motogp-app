package com.roisoftstudio.motogpfantasy.ui.dashboard.scores;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.Score;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScoreRowItemView extends FrameLayout {

    @BindView(R.id.score_row_number) TextView scoreRowNumberTextView;
    @BindView(R.id.score_row_username) TextView scoreRowUsernameTextView;
    @BindView(R.id.score_row_value) TextView scoreRowValueTextView;

    public ScoreRowItemView(@NonNull Context context) {
        this(context, null);
    }

    public ScoreRowItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScoreRowItemView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.score_row_list_item_view, this, true);
        ButterKnife.bind(this);
    }

    public void fillWith(Score score) {
        scoreRowNumberTextView.setText(String.valueOf(score.getPosition()));
        scoreRowUsernameTextView.setText(score.getUsername());
        scoreRowValueTextView.setText(String.valueOf(score.getValue()));
    }
}
