package com.visioneWEB.WebInterface.models;

import javax.persistence.*;
import java.util.List;

/*public enum Status {
    teacher ("Teacher"),
    student ("Student"),
    other ("Other");

    Status(String status) {
    }
}*/


@Entity
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    private String name;

    private String surname;

/*  Выше создано перечисление (enum), на его основе создаём
    переменную, которая может принять одно из трех значений { teacher, student, other }.*/
    private Status status;

    private boolean disease;

    @OneToOne(cascade = CascadeType.ALL)
    private biometrics biometricsID;

    @OneToMany(mappedBy = "userID")
    private List<attendance> attendanceID;



    public biometrics getBiometricsID() {
        return biometricsID;
    }

    public void setBiometricsID(biometrics biometricsID) {
        this.biometricsID = biometricsID;
    }

    public List<attendance> getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(List<attendance> attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isDisease() {
        return disease;
    }

    public void setDisease(boolean disease) {
        this.disease = disease;
    }





    public users() {
    }


    public users(String name, String surname, Status status, boolean disease) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.disease = disease;
    }

    public users(String name, String surname, Status status, boolean disease, biometrics biometricsID) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.disease = disease;
        this.biometricsID = biometricsID;
    }
}
