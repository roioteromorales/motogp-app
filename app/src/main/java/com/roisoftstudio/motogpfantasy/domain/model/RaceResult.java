package com.roisoftstudio.motogpfantasy.domain.model;

public class RaceResult {
    private final int position;
    private final String rider;
    private final String time;

    public RaceResult(int position, String rider, String time) {
        this.position = position;
        this.rider = rider;
        this.time = time;
    }

    public int getPosition() {
        return position;
    }

    public String getRider() {
        return rider;
    }

    public String getTime() {
        return time;
    }
}
