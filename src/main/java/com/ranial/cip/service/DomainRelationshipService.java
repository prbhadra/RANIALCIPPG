package com.ranial.cip.service;

import com.ranial.cip.service.dto.DomainRelationshipDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ranial.cip.domain.DomainRelationship}.
 */
public interface DomainRelationshipService {

    /**
     * Save a domainRelationship.
     *
     * @param domainRelationshipDTO the entity to save.
     * @return the persisted entity.
     */
    DomainRelationshipDTO save(DomainRelationshipDTO domainRelationshipDTO);

    /**
     * Get all the domainRelationships.
     *
     * @return the list of entities.
     */
    List<DomainRelationshipDTO> findAll();


    /**
     * Get the "id" domainRelationship.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DomainRelationshipDTO> findOne(Long id);

    /**
     * Delete the "id" domainRelationship.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
