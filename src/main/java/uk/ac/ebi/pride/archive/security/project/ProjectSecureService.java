package uk.ac.ebi.pride.archive.security.project;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectAccessException;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectService;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;

import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public interface ProjectSecureService extends ProjectService {

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
