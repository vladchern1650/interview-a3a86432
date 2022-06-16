package com.vladchern.interview.application;

import com.vladchern.interview.db.CompanyRepository;
import com.vladchern.interview.db.CompanySpecifications;
import com.vladchern.interview.domain.Company;
import com.vladchern.interview.exception.CompanyNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanySpecifications companySpecifications;

    public CompanyService(CompanyRepository companyRepository,
                          CompanySpecifications companySpecifications) {
        this.companyRepository = companyRepository;
        this.companySpecifications = companySpecifications;
    }

    public List<Company> getAll(String search) {
        Specification<Company> specification = companySpecifications.getSearchByAllFieldsSpecification(search);
        return companyRepository.findAll(specification);
    }

    public Company getById(UUID id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }
}
