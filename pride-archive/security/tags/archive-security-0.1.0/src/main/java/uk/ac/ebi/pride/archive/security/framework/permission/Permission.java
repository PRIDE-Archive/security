package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;

/**
 * @author Rui Wang
 * @version $Id$
 */
public interface Permission {
    boolean isAllowed(Authentication authentication, Object targetDomainObject);
}
