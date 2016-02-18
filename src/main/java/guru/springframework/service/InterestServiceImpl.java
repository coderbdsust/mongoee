package guru.springframework.service;

import guru.springframework.dao.InterestRepository;
import guru.springframework.domain.Interest;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestRepository interestRepository;

	@Override
	public Interest saveOrUpdate(Interest interest) {
		// TODO Auto-generated method stub
		interest = interestRepository.save(interest);
		return interest;
	}

	@Override
	public void deleteInterestById(ObjectId id) {
		// TODO Auto-generated method stub
		interestRepository.delete(id);
	}

	@Override
	public List<Interest> getInterests() {
		// TODO Auto-generated method stub

		return interestRepository.findAll();
	}

	@Override
	public Interest getInterestById(ObjectId id) {
		// TODO Auto-generated method stub
		return interestRepository.findOne(id);
	}

}
