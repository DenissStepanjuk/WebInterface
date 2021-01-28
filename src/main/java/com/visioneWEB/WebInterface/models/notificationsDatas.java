package com.visioneWEB.WebInterface.models;

import javax.persistence.*;
import java.sql.Time;


@Entity
public class notificationsDatas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationssID;

    private String messagess;

    private String pathPhoto;

    private Type typess;

    private Time time;

    private boolean checkss;

    @ManyToOne
    private partOfDay partOfDayID;



    public Long getNotificationID() {
        return notificationssID;
    }

    public void setNotificationID(Long notificationID) {
        this.notificationssID = notificationID;
    }

    public Type getType() {
        return typess;
    }

    public void setType(Type type) {
        this.typess = type;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getMessage() {
        return messagess;
    }

    public void setMessage(String message) {
        this.messagess = message;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public boolean isCheck() {
        return checkss;
    }

    public void setCheck(boolean check) {
        this.checkss = check;
    }

    public partOfDay getPartOfDayID() {
        return partOfDayID;
    }

    public void setPartOfDayID(partOfDay partOfDayID) {
        this.partOfDayID = partOfDayID;
    }
}
