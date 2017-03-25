package com.roisoftstudio.motogpfantasy.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roisoftstudio.motogpfantasy.R;

public class LastResultsActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, LastResultsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_results);
    }
}
