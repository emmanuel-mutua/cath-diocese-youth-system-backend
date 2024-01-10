package com.emmutua.dioceseyouth.user_management.repositories;

import com.emmutua.dioceseyouth.user_management.models.ParishAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParishAdminRepo extends JpaRepository<ParishAdmin, Integer> {

    List<ParishAdmin> findAllByParishId(Integer parishId);
    List<ParishAdmin> findAllByUsername(String username);

    Optional<ParishAdmin> findParishAdminByUsername(String username);
}
