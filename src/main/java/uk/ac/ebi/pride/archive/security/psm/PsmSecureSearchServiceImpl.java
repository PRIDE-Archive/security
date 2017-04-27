package uk.ac.ebi.pride.archive.security.psm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.indexutils.results.PageWrapper;
import uk.ac.ebi.pride.psmindex.search.model.Psm;
import uk.ac.ebi.pride.psmindex.search.service.PsmSearchService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Florian Reisinger
 * @since 0.1.0
 */
@SuppressWarnings("unused")
@Service
public class PsmSecureSearchServiceImpl implements PsmSecureSearchService {

    @Autowired
    PsmSearchService psmSearchService;

    @Override
    public Page<Psm> findByPeptideSequenceAndProjectAccession(String peptideSequence, String projectAccession, Pageable pageable) {
        return this.psmSearchService.findByPeptideSequenceAndProjectAccession(peptideSequence, projectAccession, pageable);
    }

    @Override
    public Long countByPeptideSequenceAndProjectAccession(String peptideSequence, String projectAccession) {
        return this.psmSearchService.countByPeptideSequenceAndProjectAccession(peptideSequence, projectAccession);
    }

    @Override
    public Page<Psm> findByPeptideSequenceAndAssayAccession(String peptideSequence, String assayAccession, Pageable pageable) {
        return this.psmSearchService.findByPeptideSequenceAndAssayAccession(peptideSequence, assayAccession, pageable);
    }

    @Override
    public Long countByPeptideSequenceAndAssayAccession(String peptideSequence, String assayAccession) {
        return this.psmSearchService.countByPeptideSequenceAndAssayAccession(peptideSequence, assayAccession);
    }

    @Override
    public List<Psm> findByProjectAccession(String projectAccession) {
        return this.psmSearchService.findByProjectAccession(projectAccession);
    }

    @Override
    public Long countByProjectAccession(String projectAccession) {
        return this.psmSearchService.countByProjectAccession(projectAccession);
    }

    @Override
    public Page<Psm> findByProjectAccession(String projectAccession, Pageable pageable) {
        return this.psmSearchService.findByProjectAccession(projectAccession, pageable);
    }

    @Override
    public List<Psm> findByProjectAccession(Collection<String> projectAccessions) {
        return this.psmSearchService.findByProjectAccession(projectAccessions);
    }

    @Override
    public Page<Psm> findByProjectAccession(Collection<String> projectAccessions, Pageable pageable) {
        return this.psmSearchService.findByProjectAccession(projectAccessions, pageable);
    }

    @Override
    public Map<String, Long> findByProjectAccessionFacetOnModificationNames(String projectAccession, String term, List<String> modNameFilters) {
        return this.psmSearchService.findByProjectAccessionFacetOnModificationNames(projectAccession, term, modNameFilters);
    }


    @Override
    public PageWrapper<Psm> findByProjectAccessionHighlightsOnModificationNames(String projectAccession, String term, List<String> modNameFilters, Pageable pageable) {
        return this.psmSearchService.findByProjectAccessionHighlightsOnModificationNames(projectAccession, term, modNameFilters, pageable);
    }

    @Override
    public List<Psm> findByAssayAccession(String assayAccession) {
        return this.psmSearchService.findByAssayAccession(assayAccession);
    }

    @Override
    public Long countByAssayAccession(String assayAccession) {
        return this.psmSearchService.countByAssayAccession(assayAccession);
    }

    @Override
    public Page<Psm> findByAssayAccession(String assayAccession, Pageable pageable) {
        return this.psmSearchService.findByAssayAccession(assayAccession, pageable);
    }

    @Override
    public List<Psm> findByAssayAccession(Collection<String> assayAccessions) {
        return this.psmSearchService.findByAssayAccession(assayAccessions);
    }

    @Override
    public Page<Psm> findByAssayAccession(Collection<String> assayAccessions, Pageable pageable) {
        return this.psmSearchService.findByAssayAccession(assayAccessions, pageable);
    }

    @Override
    public Map<String, Long> findByAssayAccessionFacetOnModificationNames(
            String assayAccession, String term, List<String> modNameFilters){
        return this.psmSearchService.findByAssayAccessionFacetOnModificationNames(assayAccession, term, modNameFilters);
    }

    @Override
    public PageWrapper<Psm> findByAssayAccessionHighlightsOnModificationNames(
            String assayAccession, String term, List<String> modNameFilters, Pageable pageable) {
        return this.psmSearchService.findByAssayAccessionHighlightsOnModificationNames(assayAccession, term, modNameFilters, pageable);
    }

    @Override
    public Page<Psm> findByProteinAccessionAndProjectAccession(String proteinAccession, String projectAccession, Pageable pageable) {
        return this.psmSearchService.findByProteinAccessionAndProjectAccession(proteinAccession, projectAccession, pageable);
    }

    @Override
    public Page<Psm> findByProteinAccessionAndAssayAccession(String proteinAccession, String assayAccession, Pageable pageable) {
        return this.psmSearchService.findByProteinAccessionAndAssayAccession(proteinAccession, assayAccession, pageable);
    }

    @Override
    public Page<String> findPeptideSequencesByProjectAccession(String projectAccession, Pageable pageable) {
        return this.psmSearchService.findPeptideSequencesByProjectAccession(projectAccession, pageable);
    }

}
