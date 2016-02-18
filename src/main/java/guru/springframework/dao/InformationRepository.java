package guru.springframework.dao;

import guru.springframework.domain.Information;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends
		MongoRepository<Information, String> {
	public Information findById(String id);
	public List<Information> findAll();
	public Information save(Information information);
	public void deleteById(String id);
	public void deleteAll();

}
