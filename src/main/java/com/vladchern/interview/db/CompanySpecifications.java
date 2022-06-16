package com.vladchern.interview.db;

import com.vladchern.interview.domain.Company;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CompanySpecifications {

    public Specification<Company> getSearchByAllFieldsSpecification(String search) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isEmpty(search)) {
                return criteriaBuilder.and();
            }

            String searchLike = "%" + search + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(root.get(Company.Fields.id).as(String.class), searchLike),
                    criteriaBuilder.like(root.get(Company.Fields.fullName), searchLike),
                    criteriaBuilder.like(root.get(Company.Fields.shortName), searchLike),
                    criteriaBuilder.like(root.get(Company.Fields.inn).as(String.class), searchLike),
                    criteriaBuilder.like(root.get(Company.Fields.ogrn).as(String.class), searchLike),
                    criteriaBuilder.like(root.get(Company.Fields.email), searchLike),
                    criteriaBuilder.like(root.get(Company.Fields.legalAddress), searchLike));
        };
    }
}
