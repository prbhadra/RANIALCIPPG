package com.ranial.cip.service.impl;

import com.ranial.cip.service.DomainService;
import com.ranial.cip.domain.Domain;
import com.ranial.cip.repository.DomainRepository;
import com.ranial.cip.service.dto.DomainDTO;
import com.ranial.cip.service.mapper.DomainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Domain}.
 */
@Service
@Transactional
public class DomainServiceImpl implements DomainService {

    private final Logger log = LoggerFactory.getLogger(DomainServiceImpl.class);

    private final DomainRepository domainRepository;

    private final DomainMapper domainMapper;

    public DomainServiceImpl(DomainRepository domainRepository, DomainMapper domainMapper) {
        this.domainRepository = domainRepository;
        this.domainMapper = domainMapper;
    }

    /**
     * Save a domain.
     *
     * @param domainDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DomainDTO save(DomainDTO domainDTO) {
        log.debug("Request to save Domain : {}", domainDTO);
        Domain domain = domainMapper.toEntity(domainDTO);
        domain = domainRepository.save(domain);
        return domainMapper.toDto(domain);
    }

    /**
     * Get all the domains.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<DomainDTO> findAll() {
        log.debug("Request to get all Domains");
        return domainRepository.findAll().stream()
            .map(domainMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one domain by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DomainDTO> findOne(Long id) {
        log.debug("Request to get Domain : {}", id);
        return domainRepository.findById(id)
            .map(domainMapper::toDto);
    }

    /**
     * Delete the domain by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Domain : {}", id);
        domainRepository.deleteById(id);
    }
}
