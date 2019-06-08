package com.ranial.cip.service.mapper;

import com.ranial.cip.domain.*;
import com.ranial.cip.service.dto.DomainRelationshipDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DomainRelationship} and its DTO {@link DomainRelationshipDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DomainRelationshipMapper extends EntityMapper<DomainRelationshipDTO, DomainRelationship> {


    @Mapping(target = "parentKeyEntityNames", ignore = true)
    @Mapping(target = "parentKeyAttributeNames", ignore = true)
    @Mapping(target = "chieldAttributeNames", ignore = true)
    DomainRelationship toEntity(DomainRelationshipDTO domainRelationshipDTO);

    default DomainRelationship fromId(Long id) {
        if (id == null) {
            return null;
        }
        DomainRelationship domainRelationship = new DomainRelationship();
        domainRelationship.setId(id);
        return domainRelationship;
    }
}
