package com.company.service.app.service;

import com.company.service.app.model.Company;

import java.util.List;

public interface CompanyService {
    Company getCompany(final String name);

    List<Company> getAllCompany();

    String saveCompany(final Company company);

    String deleteCompany(final String name) ;

    String updateCompany(final Company company);
}
