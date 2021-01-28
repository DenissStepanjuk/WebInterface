package com.visioneWEB.WebInterface.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classroomID;

    private String addres;

    private boolean door;



    public Long getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(Long classroomID) {
        this.classroomID = classroomID;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }



    public classroom() {
    }


    public classroom(String addres, boolean door) {
        this.addres = addres;
        this.door = door;
    }
}
