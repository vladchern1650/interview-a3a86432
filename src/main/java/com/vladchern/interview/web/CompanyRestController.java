package com.vladchern.interview.web;

import com.vladchern.interview.application.CompanyService;
import com.vladchern.interview.domain.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAll(@RequestParam(required = false) String search) {
        return companyService.getAll(search);
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable UUID id) {
        return companyService.getById(id);
    }
}
