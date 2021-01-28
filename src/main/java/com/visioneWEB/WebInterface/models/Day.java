package com.visioneWEB.WebInterface.models;

public enum Day {

    Monday ("Monday"),
    Tuesday ("Tuesday"),
    Wednesday ("Wednesday"),
    Thursday ("Thursday"),
    Friday ("Friday"),
    Saturday ("Saturday"),
    Sunday ("Sunday");

    private final String day;


    Day(String day) {
        this.day = day;
    }


    public String getDay() {
        return day;
    }
}
