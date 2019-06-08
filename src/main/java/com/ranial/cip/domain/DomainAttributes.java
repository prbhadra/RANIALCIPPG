package com.ranial.cip.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.ranial.cip.domain.enumeration.DATATYPE;

/**
 * A DomainAttributes.
 */
@Entity
@Table(name = "domain_attributes")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DomainAttributes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "attribute_type", nullable = false)
    private DATATYPE attributeType;

    @Column(name = "attribute_length")
    private Integer attributeLength;

    @Column(name = "attribute_description")
    private String attributeDescription;

    @NotNull
    @Column(name = "allow_null", nullable = false)
    private Boolean allowNull;

    @NotNull
    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary;

    @NotNull
    @Column(name = "is_unique", nullable = false)
    private Boolean isUnique;

    @NotNull
    @Column(name = "is_indexed", nullable = false)
    private Boolean isIndexed;

    @NotNull
    @Column(name = "is_foraign_key", nullable = false)
    private Boolean isForaignKey;

    @OneToMany(mappedBy = "domainAttributes")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Domain> entityNames = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("domainAttributes")
    private DomainRelationship domainRelationship;

    @ManyToOne
    @JsonIgnoreProperties("domainAttributes")
    private DomainRelationship domainRelationship;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public DomainAttributes attributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public DATATYPE getAttributeType() {
        return attributeType;
    }

    public DomainAttributes attributeType(DATATYPE attributeType) {
        this.attributeType = attributeType;
        return this;
    }

    public void setAttributeType(DATATYPE attributeType) {
        this.attributeType = attributeType;
    }

    public Integer getAttributeLength() {
        return attributeLength;
    }

    public DomainAttributes attributeLength(Integer attributeLength) {
        this.attributeLength = attributeLength;
        return this;
    }

    public void setAttributeLength(Integer attributeLength) {
        this.attributeLength = attributeLength;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }

    public DomainAttributes attributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
        return this;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }

    public Boolean isAllowNull() {
        return allowNull;
    }

    public DomainAttributes allowNull(Boolean allowNull) {
        this.allowNull = allowNull;
        return this;
    }

    public void setAllowNull(Boolean allowNull) {
        this.allowNull = allowNull;
    }

    public Boolean isIsPrimary() {
        return isPrimary;
    }

    public DomainAttributes isPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Boolean isIsUnique() {
        return isUnique;
    }

    public DomainAttributes isUnique(Boolean isUnique) {
        this.isUnique = isUnique;
        return this;
    }

    public void setIsUnique(Boolean isUnique) {
        this.isUnique = isUnique;
    }

    public Boolean isIsIndexed() {
        return isIndexed;
    }

    public DomainAttributes isIndexed(Boolean isIndexed) {
        this.isIndexed = isIndexed;
        return this;
    }

    public void setIsIndexed(Boolean isIndexed) {
        this.isIndexed = isIndexed;
    }

    public Boolean isIsForaignKey() {
        return isForaignKey;
    }

    public DomainAttributes isForaignKey(Boolean isForaignKey) {
        this.isForaignKey = isForaignKey;
        return this;
    }

    public void setIsForaignKey(Boolean isForaignKey) {
        this.isForaignKey = isForaignKey;
    }

    public Set<Domain> getEntityNames() {
        return entityNames;
    }

    public DomainAttributes entityNames(Set<Domain> domains) {
        this.entityNames = domains;
        return this;
    }

    public DomainAttributes addEntityName(Domain domain) {
        this.entityNames.add(domain);
        domain.setDomainAttributes(this);
        return this;
    }

    public DomainAttributes removeEntityName(Domain domain) {
        this.entityNames.remove(domain);
        domain.setDomainAttributes(null);
        return this;
    }

    public void setEntityNames(Set<Domain> domains) {
        this.entityNames = domains;
    }

    public DomainRelationship getDomainRelationship() {
        return domainRelationship;
    }

    public DomainAttributes domainRelationship(DomainRelationship domainRelationship) {
        this.domainRelationship = domainRelationship;
        return this;
    }

    public void setDomainRelationship(DomainRelationship domainRelationship) {
        this.domainRelationship = domainRelationship;
    }

    public DomainRelationship getDomainRelationship() {
        return domainRelationship;
    }

    public DomainAttributes domainRelationship(DomainRelationship domainRelationship) {
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
        if (!(o instanceof DomainAttributes)) {
            return false;
        }
        return id != null && id.equals(((DomainAttributes) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DomainAttributes{" +
            "id=" + getId() +
            ", attributeName='" + getAttributeName() + "'" +
            ", attributeType='" + getAttributeType() + "'" +
            ", attributeLength=" + getAttributeLength() +
            ", attributeDescription='" + getAttributeDescription() + "'" +
            ", allowNull='" + isAllowNull() + "'" +
            ", isPrimary='" + isIsPrimary() + "'" +
            ", isUnique='" + isIsUnique() + "'" +
            ", isIndexed='" + isIsIndexed() + "'" +
            ", isForaignKey='" + isIsForaignKey() + "'" +
            "}";
    }
}
