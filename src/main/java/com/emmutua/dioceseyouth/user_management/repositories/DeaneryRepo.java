package com.emmutua.dioceseyouth.user_management.repositories;

import com.emmutua.dioceseyouth.user_management.models.Deanery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeaneryRepo extends JpaRepository<Deanery, Integer> {

}
