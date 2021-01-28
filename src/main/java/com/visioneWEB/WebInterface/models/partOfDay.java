package com.visioneWEB.WebInterface.models;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;




@Entity
public class partOfDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partOfDayID;

    private Date date;

    private Time time_start;

    private Time time_end;

    private Parity parity;

    private Day day;

    private int numberOfWeek;

    private int numberOfLesson;

    @ManyToOne
    private timetables timetableID;

    @OneToOne
    private users userID; //Teacher ID

    @OneToOne
    private Class classID;

    @OneToOne
    private classroom classroomID;

    @OneToMany(mappedBy = "partOfDayID")
    private List<notificationsDatas> notificationssID;

    @OneToMany(mappedBy = "partOfDayID")
    private List<attendance> attendanceID;



    public Long getPartOfDayID() {
        return partOfDayID;
    }

    public void setPartOfDayID(Long partOfDayID) {
        this.partOfDayID = partOfDayID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }

    public Time getTime_end() {
        return time_end;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public Parity getParity() {
        return parity;
    }

    public void setParity(Parity parity) {
        this.parity = parity;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    public timetables getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(timetables timetableID) {
        this.timetableID = timetableID;
    }

    public users getUserID() {
        return userID;
    }

    public void setUserID(users userID) {
        this.userID = userID;
    }

    public Class getClassID() {
        return classID;
    }

    public void setClassID(Class classID) {
        this.classID = classID;
    }

    public classroom getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(classroom classroomID) {
        this.classroomID = classroomID;
    }

    public List<notificationsDatas> getNotificationID() {
        return notificationssID;
    }

    public void setNotificationID(List<notificationsDatas> notificationID) {
        this.notificationssID = notificationID;
    }

    public List<attendance> getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(List<attendance> attendanceID) {
        this.attendanceID = attendanceID;
    }








    public partOfDay() {
    }


    public partOfDay(Date date, Time time_start, Time time_end, Parity parity, Day day, int numberOfWeek,
                     int numberOfLesson, timetables timetableID, users userID, Class classID, classroom classroomID) {
        this.date = date;
        this.time_start = time_start;
        this.time_end = time_end;
        this.parity = parity;
        this.day = day;
        this.numberOfWeek = numberOfWeek;
        this.numberOfLesson = numberOfLesson;
        this.timetableID = timetableID;
        this.userID = userID;
        this.classID = classID;
        this.classroomID = classroomID;
    }
}
