package com.visioneWEB.WebInterface.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class timetables {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timetableID;

    @ManyToOne
    private groupes groupID;

    @OneToMany(mappedBy = "timetableID")
    private List<partOfDay> partOfDayID;




    public Long getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(Long timetableID) {
        this.timetableID = timetableID;
    }

    public groupes getGroupID() {
        return groupID;
    }

    public void setGroupID(groupes groupID) {
        this.groupID = groupID;
    }

    public List<partOfDay> getPartOfDayID() {
        return partOfDayID;
    }

    public void setPartOfDayID(List<partOfDay> partOfDayID) {
        this.partOfDayID = partOfDayID;
    }


    public timetables() {
    }


    public timetables(groupes groupID) {
        this.groupID = groupID;
    }
}
