package com.company.service.app.controller;

import com.company.service.app.model.Company;
import com.company.service.app.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/{name}")
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

    @DeleteMapping("/{name}")
    public String deleteCompany(@PathVariable final String name) {
        return companyService.deleteCompany(name);
    }

    @PutMapping()
    public String updateCompany(@RequestBody final Company company) {
        return companyService.updateCompany(company);
    }
}
