package com.vladchern.interview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.UUID;

/**
 * Филиал организации.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Subsidiary {

    /**
     * ID.
     */
    @Id
    private UUID id = UUID.randomUUID();

    /**
     * Организация, владеющая филиалом.
     */
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Company company;

    /**
     * Наименование.
     */
    private String name;

    /**
     * Почтовый адрес.
     */
    private String mailAddress;

    /**
     * Сведения о руководителе.
     */
    @ManyToOne
    @JoinColumn
    private Contact manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Subsidiary that = (Subsidiary) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
