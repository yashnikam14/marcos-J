package com.justfun.justfun.repositories;

import com.justfun.justfun.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
//    UserEntity findByUsername(String username);


    Optional<UserEntity> findByUsername(String name);

    boolean existsByUsername(String name);
}
