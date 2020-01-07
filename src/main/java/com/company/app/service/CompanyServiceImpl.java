package com.company.app.service;

import com.company.app.entity.Company;
import com.company.app.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final static String COMPANY_EXISTS = "Company Already Exists!";
    private final static String COMPANY_NOT_EXISTS = "Company Not Exists!";
    private final static String COMPANY_NO_RESULTS = "No search results!";
    private final static String COMPANY_ADDED = "Company Added successfully";
    private final static String COMPANY_DELETED = "Company deleted successfully!";
    private final static String COMPANY_UPDATED = "Company updated successfully!";

    @Autowired
    CompanyRepository companyRepository;

    /**
     * Get Company Details By Company name
     *
     * @param name
     * @return Company
     */
    @Override
    public Company getCompany(final String name) {
        return companyRepository.findByName(name);
    }

    /**
     * Get All available Company's
     *
     * @return List<Company>
     */
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    /**
     * Save New company and its details
     *
     * @param company
     * @return company add message
     */
    @Override
    public String saveCompany(final Company company) {
        String saveCompanyMsg = COMPANY_EXISTS;
        if (!companyRepository.existsByName(company.getName())) {
            companyRepository.save(company);
            saveCompanyMsg = COMPANY_ADDED;
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
    @Transactional()
    public String deleteCompany(final String name) {
        String companyDeleteMsg = COMPANY_NOT_EXISTS;
        if (companyRepository.existsByName(name)) {
            companyRepository.deleteByName(name);
            companyDeleteMsg = COMPANY_DELETED;
        }
        return companyDeleteMsg;
    }

    /**
     * Update Existing Company Address
     *
     * @param companyUpdate
     * @return String
     */
    @Override
    public String updateCompany(final Company companyUpdate) {
        String companyUpdateMsg = COMPANY_NOT_EXISTS;
        if (companyRepository.existsByName(companyUpdate.getName())) {
            Company company = companyRepository.findByName(companyUpdate.getName());
            company.setAddress(companyUpdate.getAddress());
            companyRepository.save(company);
            companyUpdateMsg = COMPANY_UPDATED;
        }
        return companyUpdateMsg;
    }

    /**
     *
     * @param searchString
     * @return List of company search by name or address
     */
    @Override
    public List<Company> searchCompany(final String searchString) {
        return companyRepository.findByNameContainingOrAddressContaining(searchString, searchString);
    }
}