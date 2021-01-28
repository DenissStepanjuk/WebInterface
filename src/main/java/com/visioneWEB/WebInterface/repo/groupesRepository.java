package com.visioneWEB.WebInterface.repo;

import com.visioneWEB.WebInterface.models.groupes;
import org.springframework.data.repository.CrudRepository;

public interface groupesRepository extends CrudRepository<groupes,Long> {

    public groupes findByName(String name);
}
