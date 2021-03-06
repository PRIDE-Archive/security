package uk.ac.ebi.pride.archive.security.protein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.indexutils.results.PageWrapper;
import uk.ac.ebi.pride.proteinidentificationindex.search.model.ProteinIdentification;
import uk.ac.ebi.pride.proteinidentificationindex.search.model.ProteinIdentificationSummary;
import uk.ac.ebi.pride.proteinidentificationindex.search.service.ProteinIdentificationSearchService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author florian@ebi.ac.uk
 * @since 0.1.1
 */
@SuppressWarnings("unused")
@Service
public class ProteinIdentificationSecureSearchServiceImpl implements ProteinIdentificationSecureSearchService {

  @Autowired
  ProteinIdentificationSearchService proteinIdentificationSearchService;

  @Override
  public List<ProteinIdentification> findByProjectAccession(String projectAccession) {
    return proteinIdentificationSearchService.findByProjectAccession(projectAccession);
  }

  @Override
  public Long countByProjectAccession(String projectAccession) {
    return proteinIdentificationSearchService.countByProjectAccession(projectAccession);
  }

  @Override
  public Map<String, Long> findByProjectAccessionFacetOnModificationNames(String projectAccession, String term, List<String> modNameFilters) {
    return proteinIdentificationSearchService.findByProjectAccessionFacetOnModificationNames(projectAccession, term, modNameFilters);
  }

  @Override
  public PageWrapper<ProteinIdentification> findByProjectAccessionHighlightsOnModificationNames(String projectAccession, String term, List<String> modNameFilters, Pageable pageable) {
    return proteinIdentificationSearchService.findByProjectAccessionHighlightsOnModificationNames(projectAccession, term, modNameFilters, pageable);
  }

  @Override
  public List<ProteinIdentification> findByProjectAccessionAndAccession(String projectAccession, String accession){
    return proteinIdentificationSearchService.findByProjectAccessionAndAccession(projectAccession, accession);
  }

  @Override
  public Long countByProjectAccessionAndAccession(String projectAccession, String accession){
    return proteinIdentificationSearchService.countByProjectAccessionAndAccession(projectAccession, accession);
  }

  @Override
  public List<ProteinIdentification> findByProjectAccession(Collection<String> projectAccessions) {
    return proteinIdentificationSearchService.findByProjectAccession(projectAccessions);
  }

  @Override
  public Page<ProteinIdentification> findByProjectAccession(String projectAccession, Pageable pageable) {
    return proteinIdentificationSearchService.findByProjectAccession(projectAccession, pageable);
  }

  @Override
  public Page<ProteinIdentification> findByProjectAccession(Collection<String> projectAccessions, Pageable pageable) {
    return proteinIdentificationSearchService.findByProjectAccession(projectAccessions, pageable);
  }

  @Override
  public List<ProteinIdentification> findByAssayAccession(String assayAccession) {
    return proteinIdentificationSearchService.findByAssayAccession(assayAccession);
  }

  @Override
  public Long countByAssayAccession(String assayAccession) {
    return proteinIdentificationSearchService.countByAssayAccession(assayAccession);
  }

  @Override
  public List<ProteinIdentification> findByAssayAccession(Collection<String> assayAccessions) {
    return proteinIdentificationSearchService.findByAssayAccession(assayAccessions);
  }

  @Override
  public Page<ProteinIdentification> findByAssayAccession(String assayAccession, Pageable pageable) {
    return proteinIdentificationSearchService.findByAssayAccession(assayAccession, pageable);
  }

  @Override
  public Page<ProteinIdentification> findByAssayAccession(Collection<String> assayAccessions, Pageable pageable) {
    return proteinIdentificationSearchService.findByAssayAccession(assayAccessions, pageable);
  }

  @Override
  public Map<String, Long> findByAssayAccessionFacetOnModificationNames(String assayAccession, String term, List<String> modNameFilters) {
    return proteinIdentificationSearchService.findByAssayAccessionFacetOnModificationNames(assayAccession, term, modNameFilters);
  }

  @Override
  public PageWrapper<ProteinIdentification> findByAssayAccessionHighlightsOnModificationNames(String assayAccession, String term, List<String> modNameFilters, Pageable pageable) {
    return proteinIdentificationSearchService.findByAssayAccessionHighlightsOnModificationNames(assayAccession, term, modNameFilters, pageable);
  }

  @Override
  public List<ProteinIdentificationSummary> findSummaryByProjectAccession(String projectAccession) {
    return proteinIdentificationSearchService.findSummaryByProjectAccession(projectAccession);
  }

  @Override
  public Set<String> getUniqueProteinAccessionsByProjectAccession(String projectAccession) {
    return proteinIdentificationSearchService.getUniqueProteinAccessionsByProjectAccession(projectAccession);
  }

  @Override
  public List<ProteinIdentificationSummary> findSummaryByAssayAccession(String assayAccession) {
    return proteinIdentificationSearchService.findSummaryByAssayAccession(assayAccession);
  }

  @Override
  public Set<String> getUniqueProteinAccessionsByAssayAccession(String assayAccession) {
    return proteinIdentificationSearchService.getUniqueProteinAccessionsByAssayAccession(assayAccession);
  }
}
