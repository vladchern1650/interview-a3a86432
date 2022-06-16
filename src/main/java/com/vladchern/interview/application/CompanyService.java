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


/**
 * Сервис для работы с организациями.
 */
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

    /**
     * @param search Опциональный параметр - поисковая строка. Если параметр задан, ищутся организации, для которых есть
     *               совпадения с поисковой строкой (в названии, адресе и т.п.).
     *               Если параметр пустой, возвращает список всех организаций
     * @return Список всех организаций/организаций, удовлетворяющих критериям поиска.
     */
    public List<Company> getAll(String search) {
        Specification<Company> specification = companySpecifications.getSearchByAllFieldsSpecification(search);
        return companyRepository.findAll(specification);
    }

    /**
     * @param id ID организации.
     * @return Организация, ID которой равен {@code id}
     * @throws CompanyNotFoundException Если такой компании не существует
     */
    public Company getById(UUID id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }
}
