package com.visioneWEB.WebInterface.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class groupes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupID;

    private String name;

    @OneToMany
    private List<users> users;

    @OneToMany(mappedBy = "groupID")
    private List<timetables> timetable;



    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.visioneWEB.WebInterface.models.users> getUsers() {
        return users;
    }

    public void setUsers(List<com.visioneWEB.WebInterface.models.users> users) {
        this.users = users;
    }

    public List<timetables> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<timetables> timetable) {
        this.timetable = timetable;
    }




    public groupes() {
    }

    public groupes(String name) {
        this.name = name;
    }


}
