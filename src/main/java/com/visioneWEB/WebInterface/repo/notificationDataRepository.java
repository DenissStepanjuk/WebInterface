package com.visioneWEB.WebInterface.repo;

import com.visioneWEB.WebInterface.models.Type;
import com.visioneWEB.WebInterface.models.groupes;
import com.visioneWEB.WebInterface.models.notificationsDatas;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface notificationDataRepository extends CrudRepository<notificationsDatas, Long> {

    public List<notificationsDatas> findAllByTypess (Type typess);
}
