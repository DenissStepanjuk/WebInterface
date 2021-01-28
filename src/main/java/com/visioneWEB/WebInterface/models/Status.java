package com.visioneWEB.WebInterface.models;

public enum Status {

    teacher ("Teacher"),
    student ("Student"),
    other ("Other");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
