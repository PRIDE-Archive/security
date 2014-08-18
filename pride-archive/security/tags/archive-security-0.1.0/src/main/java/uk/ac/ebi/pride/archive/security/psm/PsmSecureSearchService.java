package uk.ac.ebi.pride.archive.security.psm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import uk.ac.ebi.pride.psmindex.search.model.Psm;

import java.lang.String;
import java.util.Collection;
import java.util.List;


/**
 * @author Florian Reisinger
 * @since 0.1.0
 */
public interface PsmSecureSearchService {


//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findById(String id);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findById(Collection<String> ids);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findByPeptideSequence(String peptideSequence);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findByPeptideSequence(String peptideSequence, Pageable pageable);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findByPeptideSubSequence(String peptideSequence);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findByPeptideSubSequence(String peptideSequence, Pageable pageable);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSequenceAndProjectAccession(String peptideSequence, String projectAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSubSequenceAndProjectAccession(String peptideSequence, String projectAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSequenceAndAssayAccession(String peptideSequence, String assayAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByPeptideSubSequenceAndAssayAccession(String peptideSequence, String assayAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProjectAccession(String projectAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Page<Psm> findByProjectAccession(String projectAccession, Pageable pageable);

    @PreFilter(filterTarget = "projectAccessions", value = "hasPermission(filterObject, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProjectAccession(Collection<String> projectAccessions);

    @PreFilter(filterTarget = "projectAccessions", value = "hasPermission(filterObject, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Page<Psm> findByProjectAccession(Collection<String> projectAccessions, Pageable pageable);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByAssayAccession(String assayAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Page<Psm> findByAssayAccession(String assayAccession, Pageable pageable);

    @PreFilter(filterTarget = "assayAccessions", value = "hasPermission(filterObject, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByAssayAccession(Collection<String> assayAccessions);

    @PreFilter(filterTarget = "assayAccessions", value = "hasPermission(filterObject, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Page<Psm> findByAssayAccession(Collection<String> assayAccessions, Pageable pageable);

//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findBySpectrumId(String spectrumId);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findBySpectrumId(Collection<String> spectrumIds);
//
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findByReportedId(String reportedId);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByReportedIdAndProjectAccession(String reportedId, String projectAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByReportedIdAndAssayAccession(String reportedId, String assayAccession);

//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
//    public List<Psm> findByProteinAccession(String proteinAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProteinAccessionAndProjectAccession(String proteinAccession, String projectAccession);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<Psm> findByProteinAccessionAndAssayAccession(String proteinAccession, String assayAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<String> findPeptideSequencesByProjectAccession(String projectAccession);

    
}
