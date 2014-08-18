package uk.ac.ebi.pride.archive.security.user;

import org.springframework.security.access.prepost.PreAuthorize;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;
import uk.ac.ebi.pride.archive.repo.user.service.UserAccessException;
import uk.ac.ebi.pride.archive.repo.user.service.UserModificationException;
import uk.ac.ebi.pride.archive.repo.user.service.UserService;
import uk.ac.ebi.pride.archive.repo.user.service.UserSummary;

import java.util.List;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public interface UserSecureService extends UserService {

    @Override
    @PreAuthorize("#originalUser.id == principal.id or hasRole('ADMINISTRATOR')")
    public void update(UserSummary originalUser, UserSummary updatedUser) throws UserModificationException;

    @Override
    @PreAuthorize("#userId == principal.id or hasRole('ADMINISTRATOR')")
    public UserSummary findById(Long userId) throws UserAccessException;

    @Override
    @PreAuthorize("#email == principal.username or hasRole('ADMINISTRATOR')")
    public UserSummary findByEmail(String email) throws UserAccessException;

    @Override
    @PreAuthorize("#userId == principal.id or hasRole('ADMINISTRATOR')")
    public List<ProjectSummary> findAllProjectsById(Long userId) throws UserAccessException;

}
