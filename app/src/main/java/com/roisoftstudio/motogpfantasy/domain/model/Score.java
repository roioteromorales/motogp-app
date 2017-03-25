package com.roisoftstudio.motogpfantasy.domain.model;

public class Score {
    private final int position;
    private final String username;
    private final int value;

    public Score(int position, String username, int value) {
        this.position = position;
        this.username = username;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public String getUsername() {
        return username;
    }

    public int getValue() {
        return value;
    }
}
