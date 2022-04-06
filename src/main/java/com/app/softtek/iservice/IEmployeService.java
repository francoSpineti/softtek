package com.app.softtek.iservice;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.softtek.dto.EmployeDto;
import com.app.softtek.entity.Employe;
import com.app.softtek.utils.Validator;

public interface IEmployeService {

	Employe findByIdEmploye(Long id);
	List<EmployeDto> findAllEmployes();
	ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto requestEntity);
	Validator updateEmploye(@RequestBody EmployeDto requestEntity);
	Validator deleteEmploye(Long id);
}
