package com.quovadis.nyeriyouth.youthregistration.repositories;

import com.quovadis.nyeriyouth.youthregistration.models.ParishAdmin;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParishAdminRepo extends ListCrudRepository<ParishAdmin, Integer> {

    List<ParishAdmin> findAllByParishId(Integer parishId);
    List<ParishAdmin> findAllByUsername(String username);

    Optional<ParishAdmin> findParishAdminByUsername(String username);
}
