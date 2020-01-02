package com.company.service.app.service;

import com.company.service.app.model.Company;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {
    final List<Company> COMPANY_LIST = new ArrayList<>();

    @Override
    public Company getCompany(final String name) {
        Company company = COMPANY_LIST.stream()
                .filter(companyObj -> companyObj.getName().equals(name))
                .findFirst()
                .orElse(null);
        return company;
    }

    @Override
    public List<Company> getAllCompany() {
        return COMPANY_LIST;
    }

    @Override
    public String saveCompany(final Company company) {
        String saveCompanyMsg = "Company Added successfully";
        if(getCompany(company.getName()) == null) {
            COMPANY_LIST.add(company);
        } else {
            saveCompanyMsg = "Company Already Exists";
        }
        return saveCompanyMsg;
    }

    @Override
    public String deleteCompany(final String name) {
        final boolean isCompanyDelete = COMPANY_LIST.removeIf(companyObj -> companyObj.getName().equalsIgnoreCase(name));
        String companyDeleteMsg = "Company deleted successfully!!";
        if(!isCompanyDelete) {
            companyDeleteMsg = "Company Does't exists";
        }
        return companyDeleteMsg;
    }

    @Override
    public String updateCompany(final Company companyUpdate) {
        Company company = getCompany(companyUpdate.getName());
        String companyUpdateMsg = "Company updated successfully!!";
        if(company != null) {
            COMPANY_LIST.remove(company);
            company.setAddress(companyUpdate.getAddress());
            company.setId(companyUpdate.getId());
            COMPANY_LIST.add(company);
        } else {
            companyUpdateMsg = "Company Does't exists";
        }

        return companyUpdateMsg;
    }
}
