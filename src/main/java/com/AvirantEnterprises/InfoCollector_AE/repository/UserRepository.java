package com.AvirantEnterprises.InfoCollector_AE.repository;

import com.AvirantEnterprises.InfoCollector_AE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by their email address
    User findByEmail(String email);
}
