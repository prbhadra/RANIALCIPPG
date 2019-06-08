package com.ranial.cip.service;

import com.ranial.cip.service.dto.DomainAttributesDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.ranial.cip.domain.DomainAttributes}.
 */
public interface DomainAttributesService {

    /**
     * Save a domainAttributes.
     *
     * @param domainAttributesDTO the entity to save.
     * @return the persisted entity.
     */
    DomainAttributesDTO save(DomainAttributesDTO domainAttributesDTO);

    /**
     * Get all the domainAttributes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DomainAttributesDTO> findAll(Pageable pageable);


    /**
     * Get the "id" domainAttributes.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DomainAttributesDTO> findOne(Long id);

    /**
     * Delete the "id" domainAttributes.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
