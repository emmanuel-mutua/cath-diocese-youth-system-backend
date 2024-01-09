package com.emmutua.dioceseyouth.user_management.repositories;

import com.emmutua.dioceseyouth.user_management.models.Youth;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface YouthRegistrationRepo extends ListCrudRepository<Youth, Integer> {

}

