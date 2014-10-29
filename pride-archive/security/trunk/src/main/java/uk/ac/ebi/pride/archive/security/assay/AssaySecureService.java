package uk.ac.ebi.pride.archive.security.assay;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import uk.ac.ebi.pride.archive.repo.assay.service.AssayAccessException;
import uk.ac.ebi.pride.archive.repo.assay.service.AssayService;
import uk.ac.ebi.pride.archive.repo.assay.service.AssaySummary;

/**
 * @author Jose A. Dianes
 * @author florian@ebi.ac.uk
 * @since 0.0.1
 */
public interface AssaySecureService extends AssayService {

    // use PostAuthorize/PostFilter since for authentication we need to retrieve the
    // record anyway, so if using PreAuthorize we may have to query the record
    // twice, once for authorisation and again for the actual query

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleAssay') or hasRole('ADMINISTRATOR')")
    public AssaySummary findById(Long assayId) throws AssayAccessException;

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleAssay') or hasRole('ADMINISTRATOR')")
    public AssaySummary findByAccession(String assayAccession) throws AssayAccessException;

    @Override
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public java.util.Collection<AssaySummary> findAllByProjectAccession(String projectAccession);

    @Override
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Page<AssaySummary> findAllByProjectAccession(String projectAccession, Pageable pageable);

    @Override
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Long countByProjectAccession(String projectAccession);
}
