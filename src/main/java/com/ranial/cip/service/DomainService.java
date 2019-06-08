package com.ranial.cip.service;

import com.ranial.cip.service.dto.DomainDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ranial.cip.domain.Domain}.
 */
public interface DomainService {

    /**
     * Save a domain.
     *
     * @param domainDTO the entity to save.
     * @return the persisted entity.
     */
    DomainDTO save(DomainDTO domainDTO);

    /**
     * Get all the domains.
     *
     * @return the list of entities.
     */
    List<DomainDTO> findAll();


    /**
     * Get the "id" domain.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DomainDTO> findOne(Long id);

    /**
     * Delete the "id" domain.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
