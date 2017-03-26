package com.roisoftstudio.motogpfantasy.domain.repository;

import com.roisoftstudio.motogpfantasy.domain.model.AuthToken;
import com.roisoftstudio.motogpfantasy.domain.model.LoginCredentials;
import com.roisoftstudio.motogpfantasy.ui.login.LoginCallback;

import javax.security.auth.login.LoginException;

public interface AuthRepository {
  AuthToken getAuthToken(LoginCallback loginCallback, LoginCredentials credentials) throws LoginException;
}
