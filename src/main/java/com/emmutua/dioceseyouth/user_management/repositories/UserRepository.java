package com.emmutua.dioceseyouth.user_management.repositories;

import com.emmutua.dioceseyouth.user_management.models.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Userr, Long> {
     Optional<Userr> existsUserrByUsernameAndPasswordAndUserRole(String username, String password, String userRole);
}
