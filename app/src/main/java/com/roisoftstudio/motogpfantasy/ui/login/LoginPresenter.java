package com.roisoftstudio.motogpfantasy.ui.login;

import android.support.design.widget.Snackbar;

import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.service.LoginService;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

public class LoginPresenter {

    private View view;

    private LoginService loginService;

    @Inject
    public LoginPresenter(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setView(LoginPresenter.View view) {
        this.view = view;
    }

    public void onLoginClick(String email, String password) {
        LoginCredentials credentials = LoginCredentials.builder().email(email).password(password).build();

        try {
            loginService.login(credentials);
            view.redirectToDashboard();
        } catch (LoginException e) {
           view.showError(e.getMessage());
        }
    }

    public interface View {
        void redirectToDashboard();
        void showError(String message);
    }
}
