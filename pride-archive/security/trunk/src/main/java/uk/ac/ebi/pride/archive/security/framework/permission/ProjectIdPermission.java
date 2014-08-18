package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.repo.project.ProjectRepository;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class ProjectIdPermission extends ProjectPermission{

    private ProjectRepository projectRepository;

    public ProjectIdPermission(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (targetDomainObject instanceof Long) {
            ProjectProvider project = projectRepository.findOne((Long) targetDomainObject);
            hasPermission = super.isAllowed(authentication, project);
        }

        return hasPermission;
    }
}
