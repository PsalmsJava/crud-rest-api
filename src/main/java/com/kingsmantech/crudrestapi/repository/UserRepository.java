package com.kingsmantech.crudrestapi.repository;

import com.kingsmantech.crudrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long Id);

    User deleteByUserId(Long userId);
}
