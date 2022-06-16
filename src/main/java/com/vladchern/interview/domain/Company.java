package com.vladchern.interview.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Организация.
 */
@Entity
@Getter
@Setter
@ToString
@FieldNameConstants
public class Company {

    /**
     * ID.
     */
    @Id
    private UUID id = UUID.randomUUID();

    /**
     * Полное наименование организации.
     */
    private String fullName;

    /**
     * Краткое наименования организации.
     */
    private String shortName;

    /**
     * ИНН.
     */
    private Long inn;
    /**
     * ОГРН.
     */
    private Long ogrn;

    /**
     * Почтовый адрес.
     */
    private String email;

    /**
     * Юридический адрес.
     */
    private String legalAddress;

    /**
     * Сведения о генеральном директоре.
     */
    @ManyToOne
    @JoinColumn
    private Contact generalManager;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Subsidiary> subsidiaries;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;
        return id != null && Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
