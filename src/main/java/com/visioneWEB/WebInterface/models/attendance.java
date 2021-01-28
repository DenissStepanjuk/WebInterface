package com.visioneWEB.WebInterface.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendanceID;

    private Time time;

    private boolean attendance;

    private boolean late;

    @ManyToOne
    private users userID;

    @ManyToOne
    private partOfDay partOfDayID;


    public Long getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(Long attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }

    public users getUserID() {
        return userID;
    }

    public void setUserID(users userID) {
        this.userID = userID;
    }

    public partOfDay getPartOfDayID() {
        return partOfDayID;
    }

    public void setPartOfDayID(partOfDay partOfDayID) {
        this.partOfDayID = partOfDayID;
    }
}
