package com.ranial.cip.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.ranial.cip.domain.DomainRelationship} entity.
 */
public class DomainRelationshipDTO implements Serializable {

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DomainRelationshipDTO domainRelationshipDTO = (DomainRelationshipDTO) o;
        if (domainRelationshipDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), domainRelationshipDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DomainRelationshipDTO{" +
            "id=" + getId() +
            "}";
    }
}
