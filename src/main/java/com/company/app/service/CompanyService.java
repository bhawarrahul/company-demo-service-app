package com.company.app.service;

import com.company.app.entity.Company;

import java.util.List;

public interface CompanyService {
    Company getCompany(final String name);

    List<Company> getAllCompany();

    String saveCompany(final Company company);

    String deleteCompany(final String name);

    String updateCompany(final Company company);

    List<Company> searchCompany(final String searchString);
}
