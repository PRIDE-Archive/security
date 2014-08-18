package uk.ac.ebi.pride.archive.security.assay;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import uk.ac.ebi.pride.archive.repo.assay.service.AssayAccessException;
import uk.ac.ebi.pride.archive.repo.assay.service.AssayService;
import uk.ac.ebi.pride.archive.repo.assay.service.AssaySummary;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public interface AssaySecureService extends AssayService {

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleAssay') or hasRole('ADMINISTRATOR')")
    public AssaySummary findById(Long assayId) throws AssayAccessException;

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleAssay') or hasRole('ADMINISTRATOR')")
    public AssaySummary findByAccession(String assayAccession) throws AssayAccessException;

    @Override
    @PostFilter("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public java.util.Collection<AssaySummary> findAllByProjectAccession(String projectAccession);

}
