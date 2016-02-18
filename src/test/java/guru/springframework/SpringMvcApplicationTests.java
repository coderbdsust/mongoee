package guru.springframework;


import guru.springframework.dao.InterestRepository;

import guru.springframework.domain.Interest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringMvcApplication.class)
@WebAppConfiguration
public class SpringMvcApplicationTests {

	@Autowired
	private InterestRepository interestRepository;


	@Test
	public void contextLoads() {

	}

	@Test
	public void interestRepositoryTests() {
		
		Interest in = new Interest();
		in.setName("Biswajit");
		in.setEmail("biswajit@student.sust.edu");
		in.setBatch("2011");
		in.setInterested("Nothing");
		Interest interest = interestRepository.save(in);
	}

}
