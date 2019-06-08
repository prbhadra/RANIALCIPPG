package com.ranial.cip.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Domain.
 */
@Entity
@Table(name = "domain")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Domain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "entity_name", nullable = false)
    private String entityName;

    @Column(name = "entity_description")
    private String entityDescription;

    @Column(name = "owner")
    private String owner;

    @Column(name = "created_on")
    private Instant createdOn;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JsonIgnoreProperties("domains")
    private DomainAttributes domainAttributes;

    @ManyToOne
    @JsonIgnoreProperties("domains")
    private DomainRelationship domainRelationship;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public Domain entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public Domain entityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
        return this;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
    }

    public String getOwner() {
        return owner;
    }

    public Domain owner(String owner) {
        this.owner = owner;
        return this;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Domain createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Domain isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public DomainAttributes getDomainAttributes() {
        return domainAttributes;
    }

    public Domain domainAttributes(DomainAttributes domainAttributes) {
        this.domainAttributes = domainAttributes;
        return this;
    }

    public void setDomainAttributes(DomainAttributes domainAttributes) {
        this.domainAttributes = domainAttributes;
    }

    public DomainRelationship getDomainRelationship() {
        return domainRelationship;
    }

    public Domain domainRelationship(DomainRelationship domainRelationship) {
        this.domainRelationship = domainRelationship;
        return this;
    }

    public void setDomainRelationship(DomainRelationship domainRelationship) {
        this.domainRelationship = domainRelationship;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Domain)) {
            return false;
        }
        return id != null && id.equals(((Domain) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Domain{" +
            "id=" + getId() +
            ", entityName='" + getEntityName() + "'" +
            ", entityDescription='" + getEntityDescription() + "'" +
            ", owner='" + getOwner() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", isActive='" + isIsActive() + "'" +
            "}";
    }
}
