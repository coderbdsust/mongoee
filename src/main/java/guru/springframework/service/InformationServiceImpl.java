package guru.springframework.service;

import guru.springframework.dao.InformationRepository;
import guru.springframework.domain.Information;
import guru.springframework.utils.KeyGenerator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private InformationRepository infoRepository;

	@Override
	public void saveOrUpdate(Information information) {
		if (information.getId() == null || information.getId().equals("")) {
			information.setId(KeyGenerator.getKey());
		}
		infoRepository.save(information);
	}

	@Override
	public void deleteInformationById(String id) {
		// TODO Auto-generated method stub
		infoRepository.deleteById(id);
	}

	@Override
	public List<Information> getInformations() {
		// TODO Auto-generated method stub
		return infoRepository.findAll();
	}

	@Override
	public Information getInformationById(String id) {
		return infoRepository.findById(id);
	}

}
