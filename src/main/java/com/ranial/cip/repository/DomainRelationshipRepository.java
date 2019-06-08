package com.ranial.cip.repository;

import com.ranial.cip.domain.DomainRelationship;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the DomainRelationship entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DomainRelationshipRepository extends JpaRepository<DomainRelationship, Long> {

}
