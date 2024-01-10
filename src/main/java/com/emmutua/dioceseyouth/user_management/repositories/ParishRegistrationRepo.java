package com.emmutua.dioceseyouth.user_management.repositories;

import com.emmutua.dioceseyouth.user_management.models.Parish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParishRegistrationRepo extends JpaRepository<Parish, Integer> {
    List<Parish> findAllByDeaneryId(Integer deaneryId);
}
