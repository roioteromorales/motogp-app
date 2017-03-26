package com.roisoftstudio.motogpfantasy.domain.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginCredentials {
  private final String email;
  private final String password;

  private LoginCredentials(Builder builder) {
    email = builder.email;
    password = builder.password;
  }

  public String email() {
    return email;
  }

  public String password() {
    return password;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String email;
    private String password;

    private Builder() {
    }

    public Builder email(String val) {
      email = val;
      return this;
    }

    public Builder password(String val) {
      password = val;
      return this;
    }

    public LoginCredentials build() {
      return new LoginCredentials(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LoginCredentials that = (LoginCredentials) o;

    if (email != null ? !email.equals(that.email) : that.email != null) {
      return false;
    }
    return password != null ? password.equals(that.password) : that.password == null;
  }

  @Override
  public int hashCode() {
    int result = email != null ? email.hashCode() : 0;
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("email", email).append("password", password).toString();
  }
}
