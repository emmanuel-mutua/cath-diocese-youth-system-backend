package com.quovadis.nyeriyouth.youthregistration.repositories;

import com.quovadis.nyeriyouth.youthregistration.models.Youth;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface YouthRegistrationRepo extends ListCrudRepository<Youth, Integer> {

}
