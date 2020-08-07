package com.projectpl.safeapi.persistance.repository;

import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.persistance.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken save(VerificationToken myToken);

    VerificationToken findByToken(String existingVerificationToken);

    VerificationToken findByUser(User user);

}
