package com.ranial.cip.web.rest;

import com.ranial.cip.service.DomainAttributesService;
import com.ranial.cip.web.rest.errors.BadRequestAlertException;
import com.ranial.cip.service.dto.DomainAttributesDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.ranial.cip.domain.DomainAttributes}.
 */
@RestController
@RequestMapping("/api")
public class DomainAttributesResource {

    private final Logger log = LoggerFactory.getLogger(DomainAttributesResource.class);

    private static final String ENTITY_NAME = "domainAttributes";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DomainAttributesService domainAttributesService;

    public DomainAttributesResource(DomainAttributesService domainAttributesService) {
        this.domainAttributesService = domainAttributesService;
    }

    /**
     * {@code POST  /domain-attributes} : Create a new domainAttributes.
     *
     * @param domainAttributesDTO the domainAttributesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new domainAttributesDTO, or with status {@code 400 (Bad Request)} if the domainAttributes has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/domain-attributes")
    public ResponseEntity<DomainAttributesDTO> createDomainAttributes(@Valid @RequestBody DomainAttributesDTO domainAttributesDTO) throws URISyntaxException {
        log.debug("REST request to save DomainAttributes : {}", domainAttributesDTO);
        if (domainAttributesDTO.getId() != null) {
            throw new BadRequestAlertException("A new domainAttributes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DomainAttributesDTO result = domainAttributesService.save(domainAttributesDTO);
        return ResponseEntity.created(new URI("/api/domain-attributes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /domain-attributes} : Updates an existing domainAttributes.
     *
     * @param domainAttributesDTO the domainAttributesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated domainAttributesDTO,
     * or with status {@code 400 (Bad Request)} if the domainAttributesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the domainAttributesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/domain-attributes")
    public ResponseEntity<DomainAttributesDTO> updateDomainAttributes(@Valid @RequestBody DomainAttributesDTO domainAttributesDTO) throws URISyntaxException {
        log.debug("REST request to update DomainAttributes : {}", domainAttributesDTO);
        if (domainAttributesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DomainAttributesDTO result = domainAttributesService.save(domainAttributesDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, domainAttributesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /domain-attributes} : get all the domainAttributes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of domainAttributes in body.
     */
    @GetMapping("/domain-attributes")
    public ResponseEntity<List<DomainAttributesDTO>> getAllDomainAttributes(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of DomainAttributes");
        Page<DomainAttributesDTO> page = domainAttributesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /domain-attributes/:id} : get the "id" domainAttributes.
     *
     * @param id the id of the domainAttributesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the domainAttributesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/domain-attributes/{id}")
    public ResponseEntity<DomainAttributesDTO> getDomainAttributes(@PathVariable Long id) {
        log.debug("REST request to get DomainAttributes : {}", id);
        Optional<DomainAttributesDTO> domainAttributesDTO = domainAttributesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(domainAttributesDTO);
    }

    /**
     * {@code DELETE  /domain-attributes/:id} : delete the "id" domainAttributes.
     *
     * @param id the id of the domainAttributesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/domain-attributes/{id}")
    public ResponseEntity<Void> deleteDomainAttributes(@PathVariable Long id) {
        log.debug("REST request to delete DomainAttributes : {}", id);
        domainAttributesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
