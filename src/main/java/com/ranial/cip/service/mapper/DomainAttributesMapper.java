package com.ranial.cip.service.mapper;

import com.ranial.cip.domain.*;
import com.ranial.cip.service.dto.DomainAttributesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DomainAttributes} and its DTO {@link DomainAttributesDTO}.
 */
@Mapper(componentModel = "spring", uses = {DomainRelationshipMapper.class})
public interface DomainAttributesMapper extends EntityMapper<DomainAttributesDTO, DomainAttributes> {

    @Mapping(source = "domainRelationship.id", target = "domainRelationshipId")
    @Mapping(source = "domainRelationship.id", target = "domainRelationshipId")
    DomainAttributesDTO toDto(DomainAttributes domainAttributes);

    @Mapping(target = "entityNames", ignore = true)
    @Mapping(source = "domainRelationshipId", target = "domainRelationship")
    @Mapping(source = "domainRelationshipId", target = "domainRelationship")
    DomainAttributes toEntity(DomainAttributesDTO domainAttributesDTO);

    default DomainAttributes fromId(Long id) {
        if (id == null) {
            return null;
        }
        DomainAttributes domainAttributes = new DomainAttributes();
        domainAttributes.setId(id);
        return domainAttributes;
    }
}
