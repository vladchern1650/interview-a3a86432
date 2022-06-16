package com.vladchern.interview.web;

import com.vladchern.interview.application.CompanyService;
import com.vladchern.interview.domain.Company;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * REST-контроллер для работы с организациями.
 */
@RestController
@RequestMapping("/company")
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * @param search Опциональный параметр - поисковая строка. Если параметр задан, ищутся организации, для которых есть
     *               совпадения с поисковой строкой (в названии, адресе и т.п.).
     *               Если параметр пустой, возвращает список всех организаций
     * @return Список всех организаций/организаций, удовлетворяющих критериям поиска.
     */
    @GetMapping
    @Operation(summary = "Поиск организаций по ключевому слову",
            description = "Опциональный параметр `search` - поисковая строка. Если параметр задан, ищутся " +
                    "организации, для которых есть совпадения с поисковой строкой (в названии, адресе и т.п.). " +
                    "Если параметр пустой, возвращает список всех организаций")
    public List<Company> getAll(@RequestParam(required = false) String search) {
        return companyService.getAll(search);
    }

    /**
     * Возвращает организацию по ID. Если такой организации не существует, возвращает статус 404 (Not Found).
     *
     * @param id ID организации.
     * @return Организация, ID которой равен {@code id}
     */
    @GetMapping("/{id}")
    @Operation(summary = "Поиск организации по ID",
               description = "Возвращает организацию по ID. " +
                    "Если такой организации не существует, возвращает статус 404 (Not Found)")
    public Company getById(@PathVariable UUID id) {
        return companyService.getById(id);
    }
}
