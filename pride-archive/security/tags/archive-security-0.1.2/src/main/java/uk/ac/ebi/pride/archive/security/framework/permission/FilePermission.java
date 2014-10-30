package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.file.ProjectFileProvider;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.repo.project.ProjectRepository;

/**
 * Check whether a user has permission to access a file
 *
 * @author Rui Wang
 * @version $Id$
 */
public class FilePermission extends ProjectPermission {

    private ProjectRepository projectRepository;

    public FilePermission(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (isProjectFile(targetDomainObject)) {
            ProjectProvider project = projectRepository.findOne(((ProjectFileProvider)targetDomainObject).getProjectId());
            hasPermission = super.isAllowed(authentication, project);
        }

        return hasPermission;
    }

    private boolean isProjectFile(Object targetDomainObject) {
        return targetDomainObject != null && targetDomainObject instanceof ProjectFileProvider;
    }
}
