package com.ranial.cip.service.dto;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.ranial.cip.domain.Domain} entity.
 */
public class DomainDTO implements Serializable {

    private Long id;

    @NotNull
    private String entityName;

    private String entityDescription;

    private String owner;

    private Instant createdOn;

    private Boolean isActive;


    private Long domainAttributesId;

    private Long domainRelationshipId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getDomainAttributesId() {
        return domainAttributesId;
    }

    public void setDomainAttributesId(Long domainAttributesId) {
        this.domainAttributesId = domainAttributesId;
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

        DomainDTO domainDTO = (DomainDTO) o;
        if (domainDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), domainDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DomainDTO{" +
            "id=" + getId() +
            ", entityName='" + getEntityName() + "'" +
            ", entityDescription='" + getEntityDescription() + "'" +
            ", owner='" + getOwner() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", domainAttributes=" + getDomainAttributesId() +
            ", domainRelationship=" + getDomainRelationshipId() +
            "}";
    }
}
