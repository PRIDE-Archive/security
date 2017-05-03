package uk.ac.ebi.pride.archive.security.psm;

/*
import org.springframework.security.access.prepost.PreAuthorize;
*/
import org.springframework.data.domain.Sort;
import uk.ac.ebi.pride.psmindex.mongo.search.model.MongoPsm;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
public interface MongoPsmSecureSearchService {

  // ToDo: post filtering collections
  //       post filtering collections does not work well with paging, as the number of results may
  //       be changed due to filtering a solution defining the authorisation based on the input
  //       values would have to be implemented,so retrieved results do not have to be filtered and
  //       paging is made possible
  // ToDo: query for collection of values
  //       methods that allow querying for collections of values, should perhaps restrict the collection size
  //       in order to not generate too large result sets and to avoid the PostFilter with paging issue

/*
  @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
*/
  public MongoPsm findById(String id);

/*
  @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
*/
  public List<MongoPsm> findByIdIn(Collection<String> ids);

  public List<MongoPsm> findByIdIn(Collection<String> ids, Sort sort);

/*
 @PreAuthorize("hasPermission(#projectAccession, 'isAccessibleProjectAccession') or hasRole('ADMINISTRATOR')")
*/
  public List<MongoPsm> findByProjectAccession(String projectAccession);


}
