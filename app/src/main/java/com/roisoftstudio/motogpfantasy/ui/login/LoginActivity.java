package com.roisoftstudio.motogpfantasy.ui.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity implements LoginPresenter.View {


    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

}
