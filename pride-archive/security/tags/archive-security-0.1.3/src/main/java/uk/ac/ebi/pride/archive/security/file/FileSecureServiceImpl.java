package uk.ac.ebi.pride.archive.security.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.archive.repo.file.service.FileAccessException;
import uk.ac.ebi.pride.archive.repo.file.service.FileService;
import uk.ac.ebi.pride.archive.repo.file.service.FileSummary;

import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @author Rui Wang
 * @version $Id$
 */
@Service
public class FileSecureServiceImpl implements FileSecureService {

    @Autowired
    private FileService fileService;


    @Override
    public FileSummary findById(Long id) {
        return fileService.findById(id);
    }

    @Override
    public Collection<FileSummary> findAllByProjectAccession(String projectAccession) throws FileAccessException {
        return fileService.findAllByProjectAccession(projectAccession);
    }

    @Override
    public Collection<FileSummary> findAllByAssayAccession(String assayAccession) throws FileAccessException {
        return fileService.findAllByAssayAccession(assayAccession);
    }

    @Override
    public Collection<FileSummary> findAllByProjectId(Long projectId) throws FileAccessException {
        return fileService.findAllByProjectId(projectId);
    }

    @Override
    public Collection<FileSummary> findAllByAssayId(Long assayId) throws FileAccessException {
        return fileService.findAllByAssayId(assayId);
    }
}
