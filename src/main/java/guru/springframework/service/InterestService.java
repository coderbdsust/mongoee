package guru.springframework.service;

import java.util.List;

import org.bson.types.ObjectId;

import guru.springframework.domain.Information;
import guru.springframework.domain.Interest;

public interface InterestService {

	public Interest saveOrUpdate(Interest interest);

	public void deleteInterestById(ObjectId id);

	public List<Interest> getInterests();

	public Interest getInterestById(ObjectId id);

}
