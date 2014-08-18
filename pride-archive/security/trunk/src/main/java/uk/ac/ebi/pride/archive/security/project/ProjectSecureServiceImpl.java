package uk.ac.ebi.pride.archive.security.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectAccessException;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectService;
import uk.ac.ebi.pride.archive.repo.project.service.ProjectSummary;

import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @author Rui Wang
 * @version $Id$
 */
@SuppressWarnings("unused")
@Service
public class ProjectSecureServiceImpl implements ProjectSecureService {

    @Autowired
    private ProjectService projectService;

    @Override
    public ProjectSummary findById(Long projectId) throws ProjectAccessException {
        return projectService.findById(projectId);
    }

    @Override
    public ProjectSummary findByAccession(String projectAccession) {
        return projectService.findByAccession(projectAccession);
    }

    @Override
    public Collection<ProjectSummary> findAllBySubmitterId(Long submitterId) throws ProjectAccessException {
        return projectService.findAllBySubmitterId(submitterId);
    }

}
