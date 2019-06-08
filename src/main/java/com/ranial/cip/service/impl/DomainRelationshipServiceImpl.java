package com.ranial.cip.service.impl;

import com.ranial.cip.service.DomainRelationshipService;
import com.ranial.cip.domain.DomainRelationship;
import com.ranial.cip.repository.DomainRelationshipRepository;
import com.ranial.cip.service.dto.DomainRelationshipDTO;
import com.ranial.cip.service.mapper.DomainRelationshipMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link DomainRelationship}.
 */
@Service
@Transactional
public class DomainRelationshipServiceImpl implements DomainRelationshipService {

    private final Logger log = LoggerFactory.getLogger(DomainRelationshipServiceImpl.class);

    private final DomainRelationshipRepository domainRelationshipRepository;

    private final DomainRelationshipMapper domainRelationshipMapper;

    public DomainRelationshipServiceImpl(DomainRelationshipRepository domainRelationshipRepository, DomainRelationshipMapper domainRelationshipMapper) {
        this.domainRelationshipRepository = domainRelationshipRepository;
        this.domainRelationshipMapper = domainRelationshipMapper;
    }

    /**
     * Save a domainRelationship.
     *
     * @param domainRelationshipDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DomainRelationshipDTO save(DomainRelationshipDTO domainRelationshipDTO) {
        log.debug("Request to save DomainRelationship : {}", domainRelationshipDTO);
        DomainRelationship domainRelationship = domainRelationshipMapper.toEntity(domainRelationshipDTO);
        domainRelationship = domainRelationshipRepository.save(domainRelationship);
        return domainRelationshipMapper.toDto(domainRelationship);
    }

    /**
     * Get all the domainRelationships.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<DomainRelationshipDTO> findAll() {
        log.debug("Request to get all DomainRelationships");
        return domainRelationshipRepository.findAll().stream()
            .map(domainRelationshipMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one domainRelationship by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DomainRelationshipDTO> findOne(Long id) {
        log.debug("Request to get DomainRelationship : {}", id);
        return domainRelationshipRepository.findById(id)
            .map(domainRelationshipMapper::toDto);
    }

    /**
     * Delete the domainRelationship by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete DomainRelationship : {}", id);
        domainRelationshipRepository.deleteById(id);
    }
}
