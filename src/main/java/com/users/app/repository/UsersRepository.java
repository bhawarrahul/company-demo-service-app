package com.users.app.repository;

import com.users.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserId(String userId);

    boolean existsByUserId(String userId);

    void deleteByUserId(String userId);

    List<Users> findByNameContainingOrAddressContaining(String name, String address);
}
