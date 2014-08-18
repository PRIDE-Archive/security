package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.core.NestedRuntimeException;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class PermissionNotDefinedException extends NestedRuntimeException {

    public PermissionNotDefinedException(String msg) {
        super(msg);
    }

    public PermissionNotDefinedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
