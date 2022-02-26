package com.app.softtek;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.softtek.entity.Employe;
import com.app.softtek.repository.IEmployeRepository;

@DataJpaTest
public class EmployeTest {

	@Autowired
	private IEmployeRepository repository;
	
	@Test
	public void getAllEmployes() {
		
		Employe emp = Employe.builder()
				.id(1L)
				.name("prueba")
				.lastName("test")
				.dni(1234567)
				.active(true).build();
		repository.save(emp);
		
		Employe emp2 = Employe.builder()
				.id(2L)
				.name("prueba2")
				.lastName("test")
				.dni(1234567)
				.active(true).build();
		repository.save(emp);
		
		Employe emp3 = Employe.builder()
				.id(3L)
				.name("prueba3")
				.lastName("test")
				.dni(1234567)
				.active(true).build();
		
		repository.save(emp);
		repository.save(emp2);
		repository.save(emp3);
		
		List<Employe> emplist = repository.findAll();
		Assertions.assertThat(emplist.size()).isEqualTo(3);
	}
	
}
