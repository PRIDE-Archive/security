package uk.ac.ebi.pride.archive.security.psm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import uk.ac.ebi.pride.psmindex.search.model.Psm;

import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * @author Florian Reisinger
 * @since 0.1.0
 */
@SuppressWarnings("unused")
public interface PsmSecureSearchService {

    // ToDo: post filtering collections
    //       post filtering collections does not work well with paging, as the number of results may
    //       be changed due to filtering a solution defining the authorisation based on the input
    //       values would have to be implemented,so retrieved results do not have to be filtered and
    //       paging is made possible
    // ToDo: query for collection of values
    //       methods that allow querying for collections of values, should perhaps restrict the collection size
    //       in order to not generate too large result sets and to avoid the PostFilter with paging issue


//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findById(String id);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findById(Collection<String> ids);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findByPeptideSequence(String peptideSequence);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public Page<Psm> findByPeptideSequence(String peptideSequence, Pageable pageable);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findByPeptideSubSequence(String peptideSequence);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public Page<Psm> findByPeptideSubSequence(String peptideSequence, Pageable pageable);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSequenceAndProjectAccession(String peptideSequence, String projectAccession);
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Long countByPeptideSequenceAndProjectAccession(String peptideSequence, String projectAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSubSequenceAndProjectAccession(String peptideSequence, String projectAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSequenceAndAssayAccession(String peptideSequence, String assayAccession);
    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Long countByPeptideSequenceAndAssayAccession(String peptideSequence, String assayAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSubSequenceAndAssayAccession(String peptideSequence, String assayAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProjectAccession(String projectAccession);
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Long countByProjectAccession(String projectAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Page<Psm> findByProjectAccession(String projectAccession, Pageable pageable);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "projectAccessions", value = "hasPermission(filterObject, 'isAccessibleProjectAccession')")
    public List<Psm> findByProjectAccession(Collection<String> projectAccessions);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "projectAccessions", value = "hasPermission(filterObject, 'isAccessibleProjectAccession')")
    public Page<Psm> findByProjectAccession(Collection<String> projectAccessions, Pageable pageable);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByAssayAccession(String assayAccession);
    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Long countByAssayAccession(String assayAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Page<Psm> findByAssayAccession(String assayAccession, Pageable pageable);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "assayAccessions", value = "hasPermission(filterObject, 'isAccessibleAssayAccession')")
    public List<Psm> findByAssayAccession(Collection<String> assayAccessions);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "assayAccessions", value = "hasPermission(filterObject, 'isAccessibleAssayAccession')")
    public Page<Psm> findByAssayAccession(Collection<String> assayAccessions, Pageable pageable);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Map<String, Long> findByAssayAccessionFacetOnModificationNames(String assayAccession, String term, List<String> modNameFilters);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Map<String, Long> findByAssayAccessionFacetOnModificationSynonyms(String assayAccession, String term, List<String> modSynonymFilters);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public HighlightPage<Psm> findByAssayAccessionHighlightsOnModificationNames(String assayAccession, String term, List<String> modNameFilters, Pageable pageable);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public HighlightPage<Psm> findByAssayAccessionHighlightsOnModificationSynonyms(String assayAccession, String term, List<String> modSynonymFilters, Pageable pageable);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findBySpectrumId(String spectrumId);
//
//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findBySpectrumId(Collection<String> spectrumIds);
//
//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findByReportedId(String reportedId);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByReportedIdAndProjectAccession(String reportedId, String projectAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByReportedIdAndAssayAccession(String reportedId, String assayAccession);

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<Psm> findByProteinAccession(String proteinAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProteinAccessionAndProjectAccession(String proteinAccession, String projectAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProteinAccessionAndAssayAccession(String proteinAccession, String assayAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<String> findPeptideSequencesByProjectAccession(String projectAccession);


}
