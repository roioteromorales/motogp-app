package com.roisoftstudio.motogpfantasy.ui.start;

import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;

import javax.inject.Inject;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

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
        if (isNotEmpty(sessionRepository.getSessionToken().getToken())) {
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
