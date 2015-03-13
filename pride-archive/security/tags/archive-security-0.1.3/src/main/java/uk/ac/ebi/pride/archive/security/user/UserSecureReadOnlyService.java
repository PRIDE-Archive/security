package uk.ac.ebi.pride.archive.security.user;

import org.springframework.security.access.prepost.PreAuthorize;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;
import uk.ac.ebi.pride.archive.repo.user.service.UserAccessException;
import uk.ac.ebi.pride.archive.repo.user.service.UserSummary;

import java.util.List;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
public interface UserSecureReadOnlyService {

    public boolean isEmailedInUse(String email);

    public UserSummary login(String email, String passwordPlainText) throws UserAccessException;

    @PreAuthorize("#userId == principal.id or hasRole('ADMINISTRATOR')")
    public UserSummary findById(Long userId);

    @PreAuthorize("#email == principal.username or hasRole('ADMINISTRATOR')")
    public UserSummary findByEmail(String email);

    @PreAuthorize("#userId == principal.id or hasRole('ADMINISTRATOR')")
    public List<ProjectSummary> findAllProjectsById(Long userId);

}
