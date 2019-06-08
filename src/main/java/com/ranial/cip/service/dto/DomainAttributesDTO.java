package com.ranial.cip.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.ranial.cip.domain.enumeration.DATATYPE;

/**
 * A DTO for the {@link com.ranial.cip.domain.DomainAttributes} entity.
 */
public class DomainAttributesDTO implements Serializable {

    private Long id;

    @NotNull
    private String attributeName;

    @NotNull
    private DATATYPE attributeType;

    private Integer attributeLength;

    private String attributeDescription;

    @NotNull
    private Boolean allowNull;

    @NotNull
    private Boolean isPrimary;

    @NotNull
    private Boolean isUnique;

    @NotNull
    private Boolean isIndexed;

    @NotNull
    private Boolean isForaignKey;


    private Long domainRelationshipId;

    private Long domainRelationshipId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public DATATYPE getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(DATATYPE attributeType) {
        this.attributeType = attributeType;
    }

    public Integer getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(Integer attributeLength) {
        this.attributeLength = attributeLength;
    }

    public String getAttributeDescription() {
        return attributeDescription;
    }

    public void setAttributeDescription(String attributeDescription) {
        this.attributeDescription = attributeDescription;
    }

    public Boolean isAllowNull() {
        return allowNull;
    }

    public void setAllowNull(Boolean allowNull) {
        this.allowNull = allowNull;
    }

    public Boolean isIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Boolean isIsUnique() {
        return isUnique;
    }

    public void setIsUnique(Boolean isUnique) {
        this.isUnique = isUnique;
    }

    public Boolean isIsIndexed() {
        return isIndexed;
    }

    public void setIsIndexed(Boolean isIndexed) {
        this.isIndexed = isIndexed;
    }

    public Boolean isIsForaignKey() {
        return isForaignKey;
    }

    public void setIsForaignKey(Boolean isForaignKey) {
        this.isForaignKey = isForaignKey;
    }

    public Long getDomainRelationshipId() {
        return domainRelationshipId;
    }

    public void setDomainRelationshipId(Long domainRelationshipId) {
        this.domainRelationshipId = domainRelationshipId;
    }

    public Long getDomainRelationshipId() {
        return domainRelationshipId;
    }

    public void setDomainRelationshipId(Long domainRelationshipId) {
        this.domainRelationshipId = domainRelationshipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DomainAttributesDTO domainAttributesDTO = (DomainAttributesDTO) o;
        if (domainAttributesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), domainAttributesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DomainAttributesDTO{" +
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
            ", domainRelationship=" + getDomainRelationshipId() +
            ", domainRelationship=" + getDomainRelationshipId() +
            "}";
    }
}
