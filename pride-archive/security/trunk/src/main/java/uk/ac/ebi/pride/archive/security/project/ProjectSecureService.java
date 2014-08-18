package uk.ac.ebi.pride.archive.security.project;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectAccessException;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectService;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;

import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @author florian@ebi.ac.uk
 * @since 0.0.1
 */
public interface ProjectSecureService extends ProjectService {

    // use PostAuthorize/PostFilter since for authentication we need to retrieve the
    // Project record anyway, so if using PreAuthorize we may have to query the record
    // twice, once for authorisation and again for the actual query

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleProject') or hasRole('ADMINISTRATOR')")
    public ProjectSummary findById(Long projectId) throws ProjectAccessException;

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleProject') or hasRole('ADMINISTRATOR')")
    public ProjectSummary findByAccession(String projectAccession);

    @Override
    @PreAuthorize("hasRole('SUBMITTER')")
    public Collection<ProjectSummary> findAllBySubmitterId(Long submitterId) throws ProjectAccessException;

}
