package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.repo.project.ProjectRepository;

/**
 * Check whether a user has permission to access a project accession
 *
 * @author Rui Wang
 * @version $Id$
 */
public class ProjectAccessionPermission extends ProjectPermission {

    private ProjectRepository projectRepository;

    public ProjectAccessionPermission(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (targetDomainObject instanceof String) {
            ProjectProvider project = projectRepository.findByAccession((String) targetDomainObject);
            hasPermission = super.isAllowed(authentication, project);
        }

        return hasPermission;
    }
}
