package com.visioneWEB.WebInterface.repo;

import com.visioneWEB.WebInterface.models.Status;
import com.visioneWEB.WebInterface.models.users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface usersRepository extends CrudRepository<users,Long> {

    public List<users> findAllByStatus (Status status);




}
