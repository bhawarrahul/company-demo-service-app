package com.company.app.repository;

import com.company.app.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);

    List<Company> findByNameContainingOrAddressContaining(String name, String address);
}
