package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repo.ClientRepo;
import com.example.demo.repo.MaterRepo;
import com.example.demo.repo.SalonRepo;
import com.example.demo.service.DemoClientService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)


@Log4j2
@SpringBootTest
//@DataJdbcTest
class DemoApplicationTests {

	@Autowired
	private ClientRepo clientRepo;

	@Autowired
	private SalonRepo salonRepo;

	@Autowired
	private DemoClientService clientService;

	@Autowired
	private MaterRepo masterRepo;

	@Test
	void testRelationships() {
		/*Address a1 = new Address(40034, "Sumy", "Geroiv Krut", 76, 56);
		Set<Hobby> h1 = new HashSet();
		h1.add(new Hobby("dancing", "zumba trainings"));
		h1.add(new Hobby("reading", "motivation literatura"));
		h1.add(new Hobby("morning routine", "morning exercises, jogging, contrast washing"));

		Client c1 = new Client(null, "Petro", 60, a1, h1);
		clientRepo.save(c1);
		System.out.println(clientRepo.findAll());*/


		/*Address a2 = new Address(40007, "Sumy", "Ohtirska", 13, 16);
		Set<Hobby> h2 = new HashSet();
		h2.add(new Hobby("gym", "crossfit"));
		h2.add(new Hobby("reading", "political news"));
		Client c2 = new Client(null, "Mykola", 34, a2, h2);
		clientRepo.save(c2);

		Master m = new Master();
		m.setName("John");
		m.setSpecialization("massage");
		//m.setId(5);



		m.addClient(c2);

		masterRepo.save(m);*/

		Address a3 = new Address(40010, "Sumy", "SKD", 16, 20);
		Set<Hobby> h2 = new HashSet();
		h2.add(new Hobby("kindergarden", "Svitlychok"));
		h2.add(new Hobby("gym", "dzudo"));
		Client c2 = new Client(null, "Bogdan", 4, a3, h2);
		clientRepo.save(c2);

		Salon s = new Salon();
		s.setName("barberShop");
		s.addClient(c2);
		salonRepo.save(s);
	}
}
