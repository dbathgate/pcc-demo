package io.pivotal.pccdemo.dao;

import io.pivotal.pccdemo.model.Stuff;
import org.apache.geode.cache.query.SelectResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuffDao extends CrudRepository<Stuff, String> {


}
