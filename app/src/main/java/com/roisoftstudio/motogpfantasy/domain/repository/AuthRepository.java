package com.roisoftstudio.motogpfantasy.domain.repository;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;

import javax.security.auth.login.LoginException;

public interface AuthRepository {
  AuthToken getAuthToken(LoginCredentials credentials) throws LoginException;
}
