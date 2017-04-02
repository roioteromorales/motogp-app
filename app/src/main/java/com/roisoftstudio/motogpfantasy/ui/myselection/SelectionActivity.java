package com.roisoftstudio.motogpfantasy.ui.myselection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.roisoftstudio.motogpfantasy.R;
import com.roisoftstudio.motogpfantasy.domain.model.Category;
import com.roisoftstudio.motogpfantasy.domain.model.LapResult;
import com.roisoftstudio.motogpfantasy.domain.model.Selection;
import com.roisoftstudio.motogpfantasy.domain.model.rider.Rider;
import com.roisoftstudio.motogpfantasy.infrastructure.Injector;
import com.roisoftstudio.motogpfantasy.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.roisoftstudio.motogpfantasy.domain.model.Category.MOTO2;
import static com.roisoftstudio.motogpfantasy.domain.model.Category.MOTO3;
import static com.roisoftstudio.motogpfantasy.domain.model.Category.MOTOGP;

public class SelectionActivity extends BaseActivity implements SelectionPresenter.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.my_selection_first)
    TextView firstTv;
    @BindView(R.id.my_selection_second)
    TextView secondTv;
    @BindView(R.id.my_selection_third)
    TextView thirdTv;
    @BindView(R.id.my_selection_fastest_lap_time)
    TextView fastestLapTimeTv;
    @BindView(R.id.my_selection_fastest_lap_rider)
    TextView fastestLapRiderTv;
    @Inject
    SelectionPresenter selectionPresenter;

    private Category currentCategory;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_motogp:
                    currentCategory = MOTOGP;
                    selectionPresenter.onInitialize(currentCategory);
                    return true;
                case R.id.navigation_moto2:
                    currentCategory = MOTO2;
                    selectionPresenter.onInitialize(currentCategory);
                    return true;
                case R.id.navigation_moto3:
                    currentCategory = MOTO3;
                    selectionPresenter.onInitialize(currentCategory);
                    return true;
            }
            return false;
        }

    };
    private Rider firstPosition;
    private Rider secondPosition;
    private Rider thirdPosition;
    private LapResult fastestLap;

    public static Intent createIntent(Context context) {
        return new Intent(context, SelectionActivity.class);
    }


    @Override
    protected void injectDependencies() {
        Injector.component().inject(this);
    }

    @Override
    protected void initializeViews(Bundle savedInstanceState) {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle(getString(R.string.my_selection_activity_title));
    }

    @Override
    protected void initializePresenter() {
        selectionPresenter.setView(this);
        currentCategory = MOTOGP;
        selectionPresenter.onInitialize(currentCategory);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_selection;
    }

    @OnClick(R.id.my_selection_save_button)
    public void onMySelectionSaveButtonClick() {
        selectionPresenter.save(new Selection(firstPosition, secondPosition, thirdPosition, fastestLap), currentCategory);
    }

    @Override
    public void showMySelection(Selection selection) {
        firstPosition = selection.getFirstPosition();
        secondPosition = selection.getSecondPosition();
        thirdPosition = selection.getThirdPosition();
        fastestLap = selection.getFastestLap();

        firstTv.setText(firstPosition.getName());
        secondTv.setText(secondPosition.getName());
        thirdTv.setText(thirdPosition.getName());
        fastestLapRiderTv.setText(fastestLap.getRider().getName());
        fastestLapTimeTv.setText(fastestLap.getTime());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
