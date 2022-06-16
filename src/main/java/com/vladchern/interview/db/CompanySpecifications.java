package com.vladchern.interview.db;

import com.vladchern.interview.domain.Company;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CompanySpecifications {

    public Specification<Company> getSearchByAllFieldsSpecification(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(root.get(Company.Fields.id), search),
                criteriaBuilder.like(root.get(Company.Fields.fullName), search),
                criteriaBuilder.like(root.get(Company.Fields.shortName), search),
                criteriaBuilder.like(root.get(Company.Fields.inn), search),
                criteriaBuilder.like(root.get(Company.Fields.ogrn), search),
                criteriaBuilder.like(root.get(Company.Fields.email), search),
                criteriaBuilder.like(root.get(Company.Fields.legalAddress), search));
    }
}
