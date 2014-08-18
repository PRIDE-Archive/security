package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.assay.AssayProvider;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.repo.assay.AssayRepository;
import uk.ac.ebi.pride.archive.repo.project.ProjectRepository;

/**
 * Check whether a user has permission to access a assay accession
 *
 * @author Rui Wang
 * @version $Id$
 */
public class AssayAccessionPermission extends ProjectPermission {

    private AssayRepository assayRepository;
    private ProjectRepository projectRepository;

    public AssayAccessionPermission(AssayRepository assayRepository, ProjectRepository projectRepository) {
        this.assayRepository = assayRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (targetDomainObject instanceof String) {
            AssayProvider assay = assayRepository.findByAccession((String) targetDomainObject);
            if (assay != null) {
                ProjectProvider project = projectRepository.findOne(assay.getProjectId());
                hasPermission = super.isAllowed(authentication, project);
            }
        }

        return hasPermission;
    }
}
