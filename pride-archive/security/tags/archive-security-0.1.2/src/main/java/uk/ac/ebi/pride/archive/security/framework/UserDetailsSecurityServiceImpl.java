package uk.ac.ebi.pride.archive.security.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import uk.ac.ebi.pride.archive.dataprovider.person.UserAuthority;
import uk.ac.ebi.pride.archive.repo.user.User;
import uk.ac.ebi.pride.archive.repo.user.UserRepository;

import java.util.Set;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class UserDetailsSecurityServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsSecurityServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsSecurityServiceImpl(UserRepository userRepository) {
        if (userRepository == null) {
            throw new IllegalArgumentException("User service cannot be null");
        }

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Attempting to login as: {}", username);
        User user = userRepository.findByEmail(username);
        if (user == null) {
            String msg = "Could not find user with username '" + username + "'";
            logger.warn(msg);
            throw new UsernameNotFoundException(msg);
        }
        logger.debug("Attempting to login as: {}", username);
        Set<UserAuthority> authorities = user.getUserAuthorities();

        logger.debug("Logged in as: {} with {}", username, authorities.toString());
        return new UserDetailsSecurityImpl(user);
    }

}
