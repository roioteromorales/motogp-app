package com.roisoftstudio.motogpfantasy.domain.model;


import com.roisoftstudio.motogpfantasy.domain.model.rider.Rider;

public class LapResult {
    private int lapNumber;
    private Rider rider;
    private String time;
    private String avgSpeed;

    public LapResult(int lapNumber, Rider rider, String time, String avgSpeed) {
        this.lapNumber = lapNumber;
        this.rider = rider;
        this.time = time;
        this.avgSpeed = avgSpeed;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }
}
