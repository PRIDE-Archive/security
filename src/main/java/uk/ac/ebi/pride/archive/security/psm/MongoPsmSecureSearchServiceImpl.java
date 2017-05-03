package uk.ac.ebi.pride.archive.security.psm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uk.ac.ebi.pride.psmindex.mongo.search.model.MongoPsm;
import uk.ac.ebi.pride.psmindex.mongo.search.service.MongoPsmSearchService;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("unused")
@Service
public class MongoPsmSecureSearchServiceImpl implements MongoPsmSecureSearchService {

  @Autowired
  MongoPsmSearchService mongoPsmSearchService;

  @Override
  public MongoPsm findById(String id) {
    return this.mongoPsmSearchService.findById(id);
  }

  @Override
  public List<MongoPsm> findByIdIn(Collection<String> ids) {
    return this.mongoPsmSearchService.findByIdIn(ids);
  }

  @Override
  public List<MongoPsm> findByIdIn(Collection<String> ids, Sort sort) {
    return this.mongoPsmSearchService.findByIdIn(ids, sort);
  }

  @Override
  public List<MongoPsm> findByProjectAccession(String projectAccession) {
    return this.mongoPsmSearchService.findByProjectAccession(projectAccession);
  }

}
