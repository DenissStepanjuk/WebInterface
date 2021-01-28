package com.visioneWEB.WebInterface.models;

public enum Type {

    Disease ("Disease"),
    Unknown ("Unknown"),
    Excess ("Excess"),
    Late ("Late");

    private final String type;


    Type(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }
}
