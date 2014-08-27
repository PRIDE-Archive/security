package uk.ac.ebi.pride.archive.security.protein;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import uk.ac.ebi.pride.proteinidentificationindex.search.model.ProteinIdentification;

import java.util.Collection;
import java.util.List;

/**
 * @author florian@ebi.ac.uk
 * @since 0.1.1
 */
@SuppressWarnings("unused")
public interface ProteinIdentificationSecureSearchService {

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
//    public List<ProteinIdentification> findById(String id);// id = submitted protein accession

//    @PreAuthorize("hasRole('ADMINISTRATOR')")
//    @PostFilter("hasPermission(filterObject.projectAccession, 'isAccessibleProjectAccession')")
//    public List<ProteinIdentification> findById(Collection<String> ids);// id = submitted protein  accession

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<ProteinIdentification> findBySynonymAndProjectAccession(String synonym, String projectAccession);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public List<ProteinIdentification> findByProjectAccession(String projectAccession);
    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Long countByProjectAccession(String projectAccession);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "projectAccessions", value = "hasPermission(filterObject, 'isAccessibleProjectAccession')")
    public List<ProteinIdentification> findByProjectAccession(Collection<String> projectAccessions);

    @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
    public Page<ProteinIdentification> findByProjectAccession(String projectAccession, Pageable pageable);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "projectAccessions", value = "hasPermission(filterObject, 'isAccessibleProjectAccession')")
    public Page<ProteinIdentification> findByProjectAccession(Collection<String> projectAccessions, Pageable pageable);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<ProteinIdentification> findByAssayAccession(String assayAccession);
    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Long countByAssayAccession(String assayAccession);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "assayAccessions", value = "hasPermission(filterObject, 'isAccessibleAssayAccession')")
    public List<ProteinIdentification> findByAssayAccession(Collection<String> assayAccessions);

    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public Page<ProteinIdentification> findByAssayAccession(String assayAccession, Pageable pageable);

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PreFilter(filterTarget = "assayAccessions", value = "hasPermission(filterObject, 'isAccessibleAssayAccession')")
    public Page<ProteinIdentification> findByAssayAccession(Collection<String> assayAccessions, Pageable pageable);

    // Submitted accession query methods
    @PreAuthorize("hasPermission(#assayAccession, 'isAccessibleAssayAccession') or hasRole('ADMINISTRATOR')")
    public List<ProteinIdentification> findBySubmittedAccessionAndAssayAccession(String submittedAccession, String assayAccession);

}
