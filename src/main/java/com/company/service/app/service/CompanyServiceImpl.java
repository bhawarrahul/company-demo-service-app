package com.company.service.app.service;

import com.company.service.app.model.Company;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final static String COMPANY_EXISTS = "Company Already Exists!";
    private final static String COMPANY_NOT_EXISTS = "Company Not Existsaaa!";
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
        List<Company> companyList = CompanyJsonUtils.getAllCompany();
        if(companyList == null) {
            companyList = new ArrayList<>();
        }
        Company company = companyList.stream()
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
        return CompanyJsonUtils.getAllCompany();
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
        List<Company> companyList = CompanyJsonUtils.getAllCompany();
        if (getCompany(company.getName()) == null) {
               companyList = new ArrayList<>();
                companyList.add(company);
                CompanyJsonUtils.saveCompany(companyList);

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
        String companyDeleteMsg = COMPANY_DELETED;
        final List<Company> companyList = CompanyJsonUtils.getAllCompany();
        final boolean isCompanyDelete = companyList.removeIf(companyObj -> companyObj.getName().equalsIgnoreCase(name));
        if (!isCompanyDelete) {
            companyDeleteMsg = COMPANY_NOT_EXISTS;
        } else {
            CompanyJsonUtils.saveCompany(companyList);
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
        final List<Company> companyList = CompanyJsonUtils.getAllCompany();
        String companyUpdateMsg = COMPANY_UPDATED;
        if (company != null) {
            if(companyList !=null ) {
                companyList.remove(company);
                company.setAddress(companyUpdate.getAddress());
                companyList.add(company);
                CompanyJsonUtils.saveCompany(companyList);
            }
        } else {
            companyUpdateMsg = COMPANY_EXISTS;
        }
        return companyUpdateMsg;
    }
}
