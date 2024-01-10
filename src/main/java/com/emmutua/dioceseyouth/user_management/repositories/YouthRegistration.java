package com.emmutua.dioceseyouth.user_management.repositories;
import com.emmutua.dioceseyouth.user_management.models.Youth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YouthRegistration extends JpaRepository<Youth, Long> {
    List<Youth> findAllByParishId(Integer parishId);
    void deleteYouthByBirthCertNumber(String idOrBirthCertificateNumber);

}
