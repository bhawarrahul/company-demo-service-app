package com.company.app.controller;

import com.company.app.entity.Company;
import com.company.app.service.CompanyService;
import com.company.app.utils.constants.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.COMPANY)
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(ApiConstants.PATH_VARIABLE_NAME)
    public Company getCompany(@PathVariable final String name) {
        return companyService.getCompany(name);
    }

    @GetMapping()
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @PostMapping()
    public String saveCompany(@RequestBody final Company company) {
        return companyService.saveCompany(company);
    }

    @DeleteMapping(ApiConstants.PATH_VARIABLE_NAME)
    public String deleteCompany(@PathVariable final String name) {
        return companyService.deleteCompany(name);
    }

    @PutMapping()
    public String updateCompany(@RequestBody final Company company) {
        return companyService.updateCompany(company);
    }

    @GetMapping(ApiConstants.PATH_VARIABLE_SEARCH)
    public List<Company> searchCompany(@PathVariable final String searchString) {
        return companyService.searchCompany(searchString);
    }
}