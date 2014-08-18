package uk.ac.ebi.pride.archive.security.framework;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import uk.ac.ebi.pride.archive.dataprovider.person.UserAuthority;
import uk.ac.ebi.pride.archive.repo.user.User;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jose A. Dianes
 * @author Rui Wang
 * @version $Id$
 */
public class UserDetailsSecurityImpl implements UserDetails {
    private User originalUser;

    public UserDetailsSecurityImpl(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.originalUser = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> roles = new HashSet<String>();

        for (UserAuthority authority : originalUser.getUserAuthorities()) {
            roles.add(authority.toString());
        }

        return Collections.unmodifiableList(AuthorityUtils.createAuthorityList(roles.toArray(new String[roles.size()])));
    }

    @Override
    public String getUsername() {
        return originalUser.getEmail();
    }

    @Override
    public String getPassword() {
        return originalUser.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return originalUser.getId();
    }
}