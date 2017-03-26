package com.roisoftstudio.motogpfantasy.data.repository;

import com.roisoftstudio.motogpfantasy.domain.repository.SessionRepository;

import javax.inject.Inject;

public class InMemorySessionRepository implements SessionRepository{
    @Inject
    public InMemorySessionRepository() {
    }

    @Override
    public String getSessionToken() {
        return "token";
    }
}
