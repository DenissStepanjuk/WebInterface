package com.visioneWEB.WebInterface.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class biometrics {

    @Id
    @GeneratedValue
    private Long biometricsID;

    private String pathPhoto;

    private String PathEncode;

    private boolean checkPhoto;



    public Long getBiometricsID() {
        return biometricsID;
    }

    public void setBiometricsID(Long biometricsID) {
        this.biometricsID = biometricsID;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getPathEncode() {
        return PathEncode;
    }

    public void setPathEncode(String pathEncode) {
        PathEncode = pathEncode;
    }

    public boolean isCheckPhoto() {
        return checkPhoto;
    }

    public void setCheckPhoto(boolean checkPhoto) {
        this.checkPhoto = checkPhoto;
    }







    public biometrics() {
    }


    public biometrics(String pathPhoto, boolean checkPhoto) {
        this.pathPhoto = pathPhoto;
        this.checkPhoto = checkPhoto;
    }
}




