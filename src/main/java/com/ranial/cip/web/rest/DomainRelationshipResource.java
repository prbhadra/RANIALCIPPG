package com.ranial.cip.web.rest;

import com.ranial.cip.service.DomainRelationshipService;
import com.ranial.cip.web.rest.errors.BadRequestAlertException;
import com.ranial.cip.service.dto.DomainRelationshipDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.ranial.cip.domain.DomainRelationship}.
 */
@RestController
@RequestMapping("/api")
public class DomainRelationshipResource {

    private final Logger log = LoggerFactory.getLogger(DomainRelationshipResource.class);

    private static final String ENTITY_NAME = "domainRelationship";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DomainRelationshipService domainRelationshipService;

    public DomainRelationshipResource(DomainRelationshipService domainRelationshipService) {
        this.domainRelationshipService = domainRelationshipService;
    }

    /**
     * {@code POST  /domain-relationships} : Create a new domainRelationship.
     *
     * @param domainRelationshipDTO the domainRelationshipDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new domainRelationshipDTO, or with status {@code 400 (Bad Request)} if the domainRelationship has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/domain-relationships")
    public ResponseEntity<DomainRelationshipDTO> createDomainRelationship(@RequestBody DomainRelationshipDTO domainRelationshipDTO) throws URISyntaxException {
        log.debug("REST request to save DomainRelationship : {}", domainRelationshipDTO);
        if (domainRelationshipDTO.getId() != null) {
            throw new BadRequestAlertException("A new domainRelationship cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DomainRelationshipDTO result = domainRelationshipService.save(domainRelationshipDTO);
        return ResponseEntity.created(new URI("/api/domain-relationships/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /domain-relationships} : Updates an existing domainRelationship.
     *
     * @param domainRelationshipDTO the domainRelationshipDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated domainRelationshipDTO,
     * or with status {@code 400 (Bad Request)} if the domainRelationshipDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the domainRelationshipDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/domain-relationships")
    public ResponseEntity<DomainRelationshipDTO> updateDomainRelationship(@RequestBody DomainRelationshipDTO domainRelationshipDTO) throws URISyntaxException {
        log.debug("REST request to update DomainRelationship : {}", domainRelationshipDTO);
        if (domainRelationshipDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DomainRelationshipDTO result = domainRelationshipService.save(domainRelationshipDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, domainRelationshipDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /domain-relationships} : get all the domainRelationships.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of domainRelationships in body.
     */
    @GetMapping("/domain-relationships")
    public List<DomainRelationshipDTO> getAllDomainRelationships() {
        log.debug("REST request to get all DomainRelationships");
        return domainRelationshipService.findAll();
    }

    /**
     * {@code GET  /domain-relationships/:id} : get the "id" domainRelationship.
     *
     * @param id the id of the domainRelationshipDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the domainRelationshipDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/domain-relationships/{id}")
    public ResponseEntity<DomainRelationshipDTO> getDomainRelationship(@PathVariable Long id) {
        log.debug("REST request to get DomainRelationship : {}", id);
        Optional<DomainRelationshipDTO> domainRelationshipDTO = domainRelationshipService.findOne(id);
        return ResponseUtil.wrapOrNotFound(domainRelationshipDTO);
    }

    /**
     * {@code DELETE  /domain-relationships/:id} : delete the "id" domainRelationship.
     *
     * @param id the id of the domainRelationshipDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/domain-relationships/{id}")
    public ResponseEntity<Void> deleteDomainRelationship(@PathVariable Long id) {
        log.debug("REST request to delete DomainRelationship : {}", id);
        domainRelationshipService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
