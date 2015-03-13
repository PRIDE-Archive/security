package uk.ac.ebi.pride.archive.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;
import uk.ac.ebi.pride.archive.repo.user.service.UserAccessException;
import uk.ac.ebi.pride.archive.repo.user.service.UserModificationException;
import uk.ac.ebi.pride.archive.repo.user.service.UserService;
import uk.ac.ebi.pride.archive.repo.user.service.UserSummary;

import java.util.List;

/**
 * @author Jose A. Dianes
 * @author Rui Wang
 * @version $Id$
 */
@Service
public class UserSecureWebServiceImpl implements UserSecureService {

    @Autowired
    private UserService userServiceWebServiceImpl;

    @Override
    public UserSummary signUp(UserSummary user) throws UserModificationException {
        return userServiceWebServiceImpl.signUp(user);
    }

    @Override
    public UserSummary resetPassword(String email) throws UserModificationException {
        return userServiceWebServiceImpl.resetPassword(email);
    }

    @Override
    public void update(UserSummary originalUser, UserSummary updatedUser) throws UserModificationException {
        userServiceWebServiceImpl.update(originalUser, updatedUser);
    }

    @Override
    public boolean isEmailedInUse(String email) throws UserAccessException {
        return userServiceWebServiceImpl.isEmailedInUse(email);
    }

    @Override
    public UserSummary login(String email, String passwordPlainText) throws UserAccessException {
        return userServiceWebServiceImpl.login(email,passwordPlainText);
    }

    @Override
    public UserSummary findById(Long userId) throws UserAccessException {
        return userServiceWebServiceImpl.findById(userId);
    }

    @Override
    public UserSummary findByEmail(String email) throws UserAccessException {
        return userServiceWebServiceImpl.findByEmail(email);
    }

    @Override
    public List<ProjectSummary> findAllProjectsById(Long userId) throws UserAccessException {
        return userServiceWebServiceImpl.findAllProjectsById(userId);
    }
}
