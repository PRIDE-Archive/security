package uk.ac.ebi.pride.archive.security.protein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.proteinidentificationindex.mongo.search.model.MongoProteinIdentification;
import uk.ac.ebi.pride.proteinidentificationindex.mongo.search.service.MongoProteinIdentificationSearchService;

import java.util.Collection;
import java.util.List;

/**
 * Created by tobias on 2017-04-18.
 */
@SuppressWarnings("unused")
@Service
public class MongoProteinIdentificationSecureSearchServiceImpl implements MongoProteinIdentificationSecureSearchService {

  @Autowired
  MongoProteinIdentificationSearchService proteinIdentificationSearchService;

  @Override
  public MongoProteinIdentification findById(String id) {
    return this.proteinIdentificationSearchService.findById(id);
  }

  @Override
  public List<MongoProteinIdentification> findByIdIn(Collection<String> ids) {
    return this.proteinIdentificationSearchService.findByIdIn(ids);
  }

  @Override
  public List<MongoProteinIdentification> findByIdIn(Collection<String> ids, Sort sort) {
    return this.proteinIdentificationSearchService.findByIdIn(ids, sort);
  }

  @Override
  public List<MongoProteinIdentification> findByProjectAccession(String projectAccession) {
    return this.proteinIdentificationSearchService.findByProjectAccession(projectAccession);
  }
}
