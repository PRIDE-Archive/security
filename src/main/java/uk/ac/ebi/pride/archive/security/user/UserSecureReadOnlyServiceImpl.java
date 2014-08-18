package uk.ac.ebi.pride.archive.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;
import uk.ac.ebi.pride.archive.repo.user.service.UserAccessException;
import uk.ac.ebi.pride.archive.repo.user.service.UserService;
import uk.ac.ebi.pride.archive.repo.user.service.UserSummary;

import java.util.List;

/**
 * @author Jose A. Dianes
 * @author Rui Wang
 * @version $Id$
 */
@Service
public class UserSecureReadOnlyServiceImpl implements UserSecureReadOnlyService {

    @Autowired
    private UserService userServiceImpl;

    @Override
    public boolean isEmailedInUse(String email) throws UserAccessException {
        return userServiceImpl.isEmailedInUse(email);
    }

    @Override
    public UserSummary login(String email, String passwordPlainText) throws UserAccessException {
        return userServiceImpl.login(email,passwordPlainText);
    }

    @Override
    public UserSummary findById(Long userId) throws UserAccessException {
        return userServiceImpl.findById(userId);
    }

    @Override
    public UserSummary findByEmail(String email) throws UserAccessException {
        return userServiceImpl.findByEmail(email);
    }

    @Override
    public List<ProjectSummary> findAllProjectsById(Long userId) throws UserAccessException {
        return userServiceImpl.findAllProjectsById(userId);
    }
}
