package com.roisoftstudio.motogpfantasy.ui.start;

import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;

import javax.inject.Inject;

public class StartPresenter {
    private final SessionRepository sessionRepository;
    private View view;

    @Inject
    public StartPresenter(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void setView(View view) {
        this.view = view;
    }
    public void onInitialize() {
        if (sessionRepository.getSessionToken() != null) {
            view.redirectToDashboard();
        } else {
            view.redirectToLogin();
        }
    }

    public interface View {
        void redirectToLogin();
        void redirectToDashboard();
    }
}
