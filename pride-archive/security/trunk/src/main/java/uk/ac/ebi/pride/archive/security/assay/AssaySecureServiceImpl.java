package uk.ac.ebi.pride.archive.security.assay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.archive.repo.assay.service.AssayAccessException;
import uk.ac.ebi.pride.archive.repo.assay.service.AssayService;
import uk.ac.ebi.pride.archive.repo.assay.service.AssaySummary;

import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @author Rui Wang
 * @version $Id$
 */
@Service
public class AssaySecureServiceImpl implements AssaySecureService {

    @Autowired
    private AssayService assayService;

    @Override
    public AssaySummary findById(Long assayId) throws AssayAccessException {
        return assayService.findById(assayId);
    }

    @Override
    public AssaySummary findByAccession(String assayAccession) throws AssayAccessException {
        return assayService.findByAccession(assayAccession);
    }

    @Override
    public Collection<AssaySummary> findAllByProjectAccession(String projectAccession) {
        return assayService.findAllByProjectAccession(projectAccession);
    }

    @Override
    public Page<AssaySummary> findAllByProjectAccession(String projectAccession, Pageable pageable) {
        return assayService.findAllByProjectAccession(projectAccession, pageable);
    }

    @Override
    public Long countByProjectAccession(String projectAccession) {
        return assayService.countByProjectAccession(projectAccession);
    }
}
