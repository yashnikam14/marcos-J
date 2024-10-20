package com.justfun.justfun.repositories;

import com.justfun.justfun.entities.FunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunRepositories extends JpaRepository<FunEntity, Long> {
}
