package uk.ac.ebi.pride.archive.security.framework;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;
import uk.ac.ebi.pride.archive.security.framework.permission.Permission;
import uk.ac.ebi.pride.archive.security.framework.permission.PermissionNotDefinedException;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class UserServicePermissionEvaluator implements PermissionEvaluator {

    private final Map<String, Permission> permissionNameToPermissionMap;

    public UserServicePermissionEvaluator(Map<String, Permission> permissionNameToPermissionMap) {
        Assert.notNull(permissionNameToPermissionMap, "Permission rules cannot be null");
        this.permissionNameToPermissionMap = permissionNameToPermissionMap;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean hasPermission = false;

        if (canHandle(authentication, targetDomainObject, permission)) {
            hasPermission = checkPermission(authentication, targetDomainObject, (String)permission);
        }

        return hasPermission;
    }

    private boolean canHandle(Authentication authentication, Object targetDomainObject, Object permission) {
        return targetDomainObject != null && authentication != null && permission instanceof String;
    }

    private boolean checkPermission(Authentication authentication, Object targetDomainObject, String permissionKey) {
        verifyPermissionIsDefined(permissionKey);
        Permission permission = permissionNameToPermissionMap.get(permissionKey);
        return permission.isAllowed(authentication, targetDomainObject);
    }

    private void verifyPermissionIsDefined(String permissionKey) {
        if (!permissionNameToPermissionMap.containsKey(permissionKey)) {
            throw new PermissionNotDefinedException("No permission with key " + permissionKey + " is defined");
        }
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetDomainObject, Object permission) {
        throw new PermissionNotDefinedException("Id and Class permissions are not supported by: " + this.getClass());
    }
}
