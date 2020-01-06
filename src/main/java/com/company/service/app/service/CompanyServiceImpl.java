package com.company.service.app.service;

import com.company.service.app.model.Company;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final static List<Company> COMPANY_LIST = new ArrayList<>();

    private final static String COMPANY_EXISTS = "Company Already Exists!";
    private final static String COMPANY_ADDED = "Company Added successfully";
    private final static String COMPANY_DELETED = "Company deleted successfully!";
    private final static String COMPANY_UPDATED = "Company updated successfully!";

    /**
     * Get Company Details By Company name
     *
     * @param name
     * @return Company
     */
    @Override
    public Company getCompany(final String name) {
        Company company = COMPANY_LIST.stream()
                .filter(companyObj -> companyObj.getName().equals(name))
                .findFirst()
                .orElse(null);
        return company;
    }

    /**
     * Get All available Company's
     *
     * @return List<Company>
     */
    @Override
    public List<Company> getAllCompany() {
        return COMPANY_LIST;
    }

    /**
     * Save New company and its details
     *
     * @param company
     * @return company add message
     */
    @Override
    public String saveCompany(final Company company) {
        String saveCompanyMsg = COMPANY_ADDED;
        if (getCompany(company.getName()) == null) {
            COMPANY_LIST.add(company);
        } else {
            saveCompanyMsg = COMPANY_EXISTS;
        }
        return saveCompanyMsg;
    }

    /**
     * Delete company details by name
     *
     * @param name
     * @return company delete message
     */
    @Override
    public String deleteCompany(final String name) {
        final boolean isCompanyDelete = COMPANY_LIST.removeIf(companyObj -> companyObj.getName().equalsIgnoreCase(name));
        String companyDeleteMsg = COMPANY_DELETED;
        if (!isCompanyDelete) {
            companyDeleteMsg = COMPANY_EXISTS;
        }
        return companyDeleteMsg;
    }

    /**
     * Update Existing company Id, Address
     *
     * @param companyUpdate
     * @return String
     */
    @Override
    public String updateCompany(final Company companyUpdate) {
        Company company = getCompany(companyUpdate.getName());
        String companyUpdateMsg = COMPANY_UPDATED;
        if (company != null) {
            COMPANY_LIST.remove(company);
            company.setAddress(companyUpdate.getAddress());
            COMPANY_LIST.add(company);
        } else {
            companyUpdateMsg = COMPANY_EXISTS;
        }
        return companyUpdateMsg;
    }
}
