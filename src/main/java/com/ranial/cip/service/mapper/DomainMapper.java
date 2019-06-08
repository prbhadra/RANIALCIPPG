package com.ranial.cip.service.mapper;

import com.ranial.cip.domain.*;
import com.ranial.cip.service.dto.DomainDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Domain} and its DTO {@link DomainDTO}.
 */
@Mapper(componentModel = "spring", uses = {DomainAttributesMapper.class, DomainRelationshipMapper.class})
public interface DomainMapper extends EntityMapper<DomainDTO, Domain> {

    @Mapping(source = "domainAttributes.id", target = "domainAttributesId")
    @Mapping(source = "domainRelationship.id", target = "domainRelationshipId")
    DomainDTO toDto(Domain domain);

    @Mapping(source = "domainAttributesId", target = "domainAttributes")
    @Mapping(source = "domainRelationshipId", target = "domainRelationship")
    Domain toEntity(DomainDTO domainDTO);

    default Domain fromId(Long id) {
        if (id == null) {
            return null;
        }
        Domain domain = new Domain();
        domain.setId(id);
        return domain;
    }
}
