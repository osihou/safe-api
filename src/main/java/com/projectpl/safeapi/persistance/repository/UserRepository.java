package com.projectpl.safeapi.persistance.repository;

import com.projectpl.safeapi.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findByEmail(String email);

    void deleteUserById(long id);
}
