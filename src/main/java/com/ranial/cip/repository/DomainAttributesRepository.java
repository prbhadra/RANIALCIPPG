package com.ranial.cip.repository;

import com.ranial.cip.domain.DomainAttributes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the DomainAttributes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DomainAttributesRepository extends JpaRepository<DomainAttributes, Long> {

}
