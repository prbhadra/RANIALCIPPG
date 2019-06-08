package com.ranial.cip.web.rest;

import com.ranial.cip.service.DomainService;
import com.ranial.cip.web.rest.errors.BadRequestAlertException;
import com.ranial.cip.service.dto.DomainDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.ranial.cip.domain.Domain}.
 */
@RestController
@RequestMapping("/api")
public class DomainResource {

    private final Logger log = LoggerFactory.getLogger(DomainResource.class);

    private static final String ENTITY_NAME = "domain";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DomainService domainService;

    public DomainResource(DomainService domainService) {
        this.domainService = domainService;
    }

    /**
     * {@code POST  /domains} : Create a new domain.
     *
     * @param domainDTO the domainDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new domainDTO, or with status {@code 400 (Bad Request)} if the domain has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/domains")
    public ResponseEntity<DomainDTO> createDomain(@Valid @RequestBody DomainDTO domainDTO) throws URISyntaxException {
        log.debug("REST request to save Domain : {}", domainDTO);
        if (domainDTO.getId() != null) {
            throw new BadRequestAlertException("A new domain cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DomainDTO result = domainService.save(domainDTO);
        return ResponseEntity.created(new URI("/api/domains/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /domains} : Updates an existing domain.
     *
     * @param domainDTO the domainDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated domainDTO,
     * or with status {@code 400 (Bad Request)} if the domainDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the domainDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/domains")
    public ResponseEntity<DomainDTO> updateDomain(@Valid @RequestBody DomainDTO domainDTO) throws URISyntaxException {
        log.debug("REST request to update Domain : {}", domainDTO);
        if (domainDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DomainDTO result = domainService.save(domainDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, domainDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /domains} : get all the domains.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of domains in body.
     */
    @GetMapping("/domains")
    public List<DomainDTO> getAllDomains() {
        log.debug("REST request to get all Domains");
        return domainService.findAll();
    }

    /**
     * {@code GET  /domains/:id} : get the "id" domain.
     *
     * @param id the id of the domainDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the domainDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/domains/{id}")
    public ResponseEntity<DomainDTO> getDomain(@PathVariable Long id) {
        log.debug("REST request to get Domain : {}", id);
        Optional<DomainDTO> domainDTO = domainService.findOne(id);
        return ResponseUtil.wrapOrNotFound(domainDTO);
    }

    /**
     * {@code DELETE  /domains/:id} : delete the "id" domain.
     *
     * @param id the id of the domainDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/domains/{id}")
    public ResponseEntity<Void> deleteDomain(@PathVariable Long id) {
        log.debug("REST request to delete Domain : {}", id);
        domainService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
