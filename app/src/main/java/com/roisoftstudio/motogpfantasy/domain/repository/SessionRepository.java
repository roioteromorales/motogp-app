package com.roisoftstudio.motogpfantasy.domain.repository;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;

public interface SessionRepository {
    void createSession(AuthToken token);
    void cleanSession();
    AuthToken getSessionToken();}
