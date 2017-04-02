package com.roisoftstudio.motogpfantasy.domain.model;

import com.roisoftstudio.motogpfantasy.domain.model.rider.Rider;

public class Selection {
    private final Rider firstPosition;
    private final Rider secondPosition;
    private final Rider thirdPosition;
    private final LapResult fastestLap;

    public Selection(Rider firstPosition, Rider secondPosition, Rider thirdPosition, LapResult fastestLap) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.fastestLap = fastestLap;
    }

    public Rider getFirstPosition() {
        return firstPosition;
    }

    public Rider getSecondPosition() {
        return secondPosition;
    }

    public Rider getThirdPosition() {
        return thirdPosition;
    }

    public LapResult getFastestLap() {
        return fastestLap;
    }

}
