package guru.springframework.service;

import java.util.List;

import guru.springframework.domain.Information;

public interface InformationService {

	public void saveOrUpdate(Information information);

	public void deleteInformationById(String id);

	public List<Information> getInformations();

	public Information getInformationById(String id);

}
