package com.visioneWEB.WebInterface.models;

public enum Parity {

    no_matter ("no matter"),
    even ("even"),
    odd ("odd");

    private final String parity;


    Parity(String parity) {
        this.parity = parity;
    }


    public String getParity() {
        return parity;
    }
}
