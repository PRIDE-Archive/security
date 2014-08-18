package uk.ac.ebi.pride.archive.security.file;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import uk.ac.ebi.pride.archive.repo.file.service.FileAccessException;
import uk.ac.ebi.pride.archive.repo.file.service.FileService;
import uk.ac.ebi.pride.archive.repo.file.service.FileSummary;

import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @since 0.0.1
 */
public interface FileSecureService extends FileService {

    @Override
    @PostAuthorize("hasPermission(returnObject, 'isAccessibleFile') or hasRole('ADMINISTRATOR')")
    public FileSummary findById(Long id);

    @Override
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Collection<FileSummary> findAllByProjectAccession(String projectAccession) throws FileAccessException;

    @Override
    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Collection<FileSummary> findAllByAssayAccession(String assayAccession) throws FileAccessException;

    @Override
    @PreAuthorize("hasPermission(#projectId, 'isAccessibleProjectId') or hasRole('ADMINISTRATOR')")
    public Collection<FileSummary> findAllByProjectId(Long projectId) throws FileAccessException;

    @Override
    @PreAuthorize("hasPermission(#assayId, 'isAccessibleAssayId') or hasRole('ADMINISTRATOR')")
    public Collection<FileSummary> findAllByAssayId(Long assayId) throws FileAccessException;


}
