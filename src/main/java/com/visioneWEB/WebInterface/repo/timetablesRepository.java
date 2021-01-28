package com.visioneWEB.WebInterface.repo;

import com.visioneWEB.WebInterface.models.Status;
import com.visioneWEB.WebInterface.models.groupes;
import com.visioneWEB.WebInterface.models.timetables;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface timetablesRepository extends CrudRepository<timetables,Long> {

    public List<timetables> findAllByGroupID (groupes group);
}
