package com.roisoftstudio.motogpfantasy.ui.login;

import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;
import com.roisoftstudio.motogpfantasy.domain.service.LoginService;

import javax.inject.Inject;

public class LoginPresenter {

    private View view;

    private LoginService loginService;
    private SessionRepository sessionRepository;

    @Inject
    public LoginPresenter(LoginService loginService, SessionRepository sessionRepository) {
        this.loginService = loginService;
        this.sessionRepository = sessionRepository;
    }

    public void setView(LoginPresenter.View view) {
        this.view = view;
    }

    public void onLoginClick(String email, String password) {
        LoginCredentials credentials = LoginCredentials.builder().email(email).password(password).build();
        loginService.login(new LoginCallback(view, sessionRepository), credentials);
    }

    public interface View {
        void redirectToDashboard();

        void showError(String message);
    }
}
