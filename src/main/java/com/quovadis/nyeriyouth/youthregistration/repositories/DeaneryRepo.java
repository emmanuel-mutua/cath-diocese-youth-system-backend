package com.quovadis.nyeriyouth.youthregistration.repositories;

import com.quovadis.nyeriyouth.youthregistration.models.Deanery;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeaneryRepo extends ListCrudRepository<Deanery, Integer> {

}
