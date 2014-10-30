package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.person.UserProvider;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.security.framework.UserDetailsSecurityImpl;

/**
 * Check whether a user has permission to access a project
 *
 * @author Rui Wang
 * @version $Id$
 */
public class ProjectPermission implements Permission {

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (isProject(targetDomainObject)) {
            if (isPublicProject((ProjectProvider) targetDomainObject)) {
                hasPermission = true;
            } else if (isAuthenticated(authentication)) {
                Long userId = getUserId(authentication);
                hasPermission = checkPermission((ProjectProvider) targetDomainObject, userId);
            }
        }

        return hasPermission;
    }

    protected boolean isPublicProject(ProjectProvider project) {
        return project.isPublicProject();
    }

    protected Long getUserId(Authentication authentication) {
        UserDetailsSecurityImpl userDetails = (UserDetailsSecurityImpl) authentication.getPrincipal();
        return userDetails.getId();
    }

    protected boolean checkPermission(ProjectProvider project, Long userId) {
        if (project.getSubmitter().getId().equals(userId)) {
            return true;
        }

        if (project.getUsers() != null) {
            for (UserProvider user : project.getUsers()) {
                if (user.getId().equals(userId)) {
                    return true;
                }
            }
        }

        return false;
    }

    protected boolean isProject(Object targetDomainObject) {
        return targetDomainObject != null && targetDomainObject instanceof ProjectProvider;
    }

    protected boolean isAuthenticated(Authentication authentication) {
        return authentication != null && authentication.getPrincipal() instanceof UserDetailsSecurityImpl;
    }
}
