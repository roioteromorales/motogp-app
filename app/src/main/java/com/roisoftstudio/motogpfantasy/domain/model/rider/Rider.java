package com.roisoftstudio.motogpfantasy.domain.model.rider;

public class Rider {
    private int number;
    private String name;
    private String nationality;
    private String team;
    private String bike;

    public Rider(int number, String name, String nationality, String team, String bike) {
        this.number = number;
        this.name = name;
        this.nationality = nationality;
        this.team = team;
        this.bike = bike;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTeam() {
        return team;
    }

    public String getBike() {
        return bike;
    }
}
