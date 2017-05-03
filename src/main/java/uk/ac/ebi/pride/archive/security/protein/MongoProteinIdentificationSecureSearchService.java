package uk.ac.ebi.pride.archive.security.protein;

import uk.ac.ebi.pride.proteinidentificationindex.mongo.search.model.MongoProteinIdentification;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

/**
 * Created by tobias on 2017-04-18.
 */
@SuppressWarnings("unused")
public interface MongoProteinIdentificationSecureSearchService {
  public MongoProteinIdentification findById(String id);

  public List<MongoProteinIdentification> findByIdIn(Collection<String> ids);

  public List<MongoProteinIdentification> findByIdIn(Collection<String> ids, Sort sort);

  public List<MongoProteinIdentification> findByProjectAccession(String projectAccession);

}
