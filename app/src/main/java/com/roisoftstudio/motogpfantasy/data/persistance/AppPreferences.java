package com.roisoftstudio.motogpfantasy.data.persistance;

import android.content.SharedPreferences;

import javax.inject.Inject;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class AppPreferences {
    private static String TOKEN = "TOKEN";
    private SharedPreferences preferences;

    @Inject
    public AppPreferences(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void write(String authToken) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TOKEN, authToken);
        editor.commit();
    }

    public String read() {
        return preferences.getString(TOKEN, EMPTY);
    }
}
