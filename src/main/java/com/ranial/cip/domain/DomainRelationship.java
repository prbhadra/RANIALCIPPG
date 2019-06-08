package com.ranial.cip.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DomainRelationship.
 */
@Entity
@Table(name = "domain_relationship")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DomainRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToMany(mappedBy = "domainRelationship")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Domain> parentKeyEntityNames = new HashSet<>();

    @OneToMany(mappedBy = "domainRelationship")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<DomainAttributes> parentKeyAttributeNames = new HashSet<>();

    @OneToMany(mappedBy = "domainRelationship")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<DomainAttributes> chieldAttributeNames = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Domain> getParentKeyEntityNames() {
        return parentKeyEntityNames;
    }

    public DomainRelationship parentKeyEntityNames(Set<Domain> domains) {
        this.parentKeyEntityNames = domains;
        return this;
    }

    public DomainRelationship addParentKeyEntityName(Domain domain) {
        this.parentKeyEntityNames.add(domain);
        domain.setDomainRelationship(this);
        return this;
    }

    public DomainRelationship removeParentKeyEntityName(Domain domain) {
        this.parentKeyEntityNames.remove(domain);
        domain.setDomainRelationship(null);
        return this;
    }

    public void setParentKeyEntityNames(Set<Domain> domains) {
        this.parentKeyEntityNames = domains;
    }

    public Set<DomainAttributes> getParentKeyAttributeNames() {
        return parentKeyAttributeNames;
    }

    public DomainRelationship parentKeyAttributeNames(Set<DomainAttributes> domainAttributes) {
        this.parentKeyAttributeNames = domainAttributes;
        return this;
    }

    public DomainRelationship addParentKeyAttributeName(DomainAttributes domainAttributes) {
        this.parentKeyAttributeNames.add(domainAttributes);
        domainAttributes.setDomainRelationship(this);
        return this;
    }

    public DomainRelationship removeParentKeyAttributeName(DomainAttributes domainAttributes) {
        this.parentKeyAttributeNames.remove(domainAttributes);
        domainAttributes.setDomainRelationship(null);
        return this;
    }

    public void setParentKeyAttributeNames(Set<DomainAttributes> domainAttributes) {
        this.parentKeyAttributeNames = domainAttributes;
    }

    public Set<DomainAttributes> getChieldAttributeNames() {
        return chieldAttributeNames;
    }

    public DomainRelationship chieldAttributeNames(Set<DomainAttributes> domainAttributes) {
        this.chieldAttributeNames = domainAttributes;
        return this;
    }

    public DomainRelationship addChieldAttributeName(DomainAttributes domainAttributes) {
        this.chieldAttributeNames.add(domainAttributes);
        domainAttributes.setDomainRelationship(this);
        return this;
    }

    public DomainRelationship removeChieldAttributeName(DomainAttributes domainAttributes) {
        this.chieldAttributeNames.remove(domainAttributes);
        domainAttributes.setDomainRelationship(null);
        return this;
    }

    public void setChieldAttributeNames(Set<DomainAttributes> domainAttributes) {
        this.chieldAttributeNames = domainAttributes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DomainRelationship)) {
            return false;
        }
        return id != null && id.equals(((DomainRelationship) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DomainRelationship{" +
            "id=" + getId() +
            "}";
    }
}
