package uk.ac.ebi.pride.archive.security.framework.permission;

import org.springframework.security.core.Authentication;
import uk.ac.ebi.pride.archive.dataprovider.assay.AssayProvider;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.repo.assay.AssayRepository;
import uk.ac.ebi.pride.archive.repo.project.ProjectRepository;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class AssayIdPermission extends ProjectPermission{
    private AssayRepository assayRepository;
    private ProjectRepository projectRepository;

    public AssayIdPermission(AssayRepository assayRepository, ProjectRepository projectRepository) {
        this.assayRepository = assayRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean isAllowed(Authentication authentication, Object targetDomainObject) {
        boolean hasPermission = false;

        if (targetDomainObject instanceof Long) {
            AssayProvider assay = assayRepository.findOne((Long) targetDomainObject);
            if (assay != null) {
                ProjectProvider project = projectRepository.findOne(assay.getProjectId());
                hasPermission = super.isAllowed(authentication, project);
            }
        }

        return hasPermission;
    }
}
