package com.roisoftstudio.motogpfantasy.ui.myselection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roisoftstudio.motogpfantasy.R;

public class MySelectionActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, MySelectionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_selection);
    }
}
