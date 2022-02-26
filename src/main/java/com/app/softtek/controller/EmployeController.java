package com.app.softtek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.softtek.dto.EmployeDto;
import com.app.softtek.iservice.IEmployeService;

@RestController
@RequestMapping (path = "${controller.employe}")
public class EmployeController {

	@Autowired
	private IEmployeService service;
	
	@GetMapping(path = "${list.employe}")
	public List<EmployeDto> getEmployes() {
		return service.findAllEmployes();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "${create.employe}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity createEmploye(@RequestBody EmployeDto requestEntity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.createEmploye(requestEntity));
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "${update.employe}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity updateEmploye(@RequestBody EmployeDto requestEntity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateEmploye(requestEntity));
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "${delete.employe}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity deleteEmploye(@RequestParam Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteEmploye(id));
	}
}
