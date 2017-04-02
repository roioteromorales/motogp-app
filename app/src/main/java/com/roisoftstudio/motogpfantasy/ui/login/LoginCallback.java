package com.roisoftstudio.motogpfantasy.ui.login;

import android.util.Log;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.Score;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;
import com.roisoftstudio.motogpfantasy.ui.dashboard.DashboardPresenter;

import java.io.IOException;
import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCallback implements Callback<AuthToken> {
    private static final String TAG = "DashboardScoresCallback";

    private LoginPresenter.View loginView;
    private final SessionRepository sessionRepository;

    public LoginCallback(LoginPresenter.View loginView, SessionRepository sessionRepository) {
        this.loginView = loginView;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
        String message = "Login Success";
        if (response.isSuccessful()) {
            sessionRepository.createSession(response.body());
            loginView.redirectToDashboard();
        } else {
            try {
                message = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loginView.showError(message);
    }

    @Override
    public void onFailure(Call<AuthToken> call, Throwable t) {
        Log.v(TAG, t.getMessage() + ":", t);
        loginView.showError(t.getMessage());
    }
}
