package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.assay.AssayProvider;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.repo.project.ProjectRepository;

/**
 * Check whether a user has permission to access a assay summary
 *
 * @author Rui Wang
 * @version $Id$
 */
public class AssayPermission extends ProjectPermission{

    private ProjectRepository projectRepository;

    public AssayPermission(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (isAssay(targetDomainObject)) {
            ProjectProvider project = projectRepository.findOne(((AssayProvider)targetDomainObject).getProjectId());
            hasPermission = super.isAllowed(authentication, project);
        }

        return hasPermission;
    }

    private boolean isAssay(Object targetDomainObject) {
        return targetDomainObject != null && targetDomainObject instanceof AssayProvider;
    }
}
